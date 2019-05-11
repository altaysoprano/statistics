import java.text.DecimalFormat;
import java.util.Scanner;

public class MerkeziEgilimOlculeri {

	int x[], sayiAdedi, sayisi[];
	double farkKare[];
	double bolumler[];
	double mdtoplam;
	double oms;
	double birinciceyrek;
	double ikinciceyrek;
	double küpüToplam;
	double dkuvvetiToplam;
	
	public MerkeziEgilimOlculeri(int sayiAdedi)
	{
		this.sayiAdedi = sayiAdedi;
		x = new int[sayiAdedi];
		sayisi = new int[sayiAdedi];
		farkKare = new double[sayiAdedi];
		bolumler = new double[sayiAdedi];
	}
	
	public void hesapla()
	{
		int i, a, toplam=0;
		double aritmetikortalama=0;
		double geometrikortalama=0;
		double carpim = 1;
		int mod=0;
		int enCokOlan;
		for(i=0;i<sayiAdedi;i++)
		{
			System.out.println("Sayi giriniz: ");
			Scanner girdi = new Scanner(System.in);
			x[i] = girdi.nextInt();
		}
		for(i=0;i<sayiAdedi;i++)
		{
			toplam = toplam + x[i];
		}
		aritmetikortalama = (double) toplam / sayiAdedi;
		System.out.println("Aritmetik Ortalama: " + aritmetikortalama);
		
		for(i=0;i<sayiAdedi;i++)
		{
			carpim = carpim * x[i];
		}
		geometrikortalama = (double) Math.pow(carpim, 1/(double)sayiAdedi);
		System.out.println("Geometrik Ortalama: " + geometrikortalama);
		
		for(i=0;i<sayiAdedi;i++)
		{
			for(a=0;a<sayiAdedi;a++)
			{
				if(x[i]==x[a])
				{
					sayisi[i]++;
				}
			}
		}
		int b;
		for(i=0;i<sayiAdedi-1;i++)
		{
			for(a=0;a<sayiAdedi-1;a++)
			{
				if(x[a]>x[a+1])
				{
					b=x[a+1];
					x[a+1]=x[a];
					x[a]=b;
				}
			}
		}
		System.out.println("Basit sýralama: ");
		for(i=0;i<sayiAdedi;i++)
		{
			System.out.println(x[i]);
		}
		
		double medyan = 0;
		
		if(sayiAdedi%2==0)
		{
			medyan = (double)(x[(sayiAdedi/2)-1]+x[(sayiAdedi/2)])/2;
		}
		if(sayiAdedi%2!=0)
		{
			medyan =(double)(x[sayiAdedi/2-(1/2)]);
		}
		System.out.println("Medyan: " + medyan);
		
		for(i=0;i<sayiAdedi;i++)
		{
			farkKare[i] = Math.pow((double) x[i]- aritmetikortalama, 2);
		}
		double farkKareToplam = 0;
		for(i=0;i<sayiAdedi;i++)
		{
			farkKareToplam = farkKareToplam + farkKare[i];
		}
		double toplamBolum = farkKareToplam / (sayiAdedi-1);
		double standartSapma = Math.sqrt(toplamBolum);
		System.out.println("Standart Sapma : " + standartSapma);
		double varyans = Math.pow(standartSapma, 2);
		double roundOff = Math.round(varyans * 100.0) / 100.0;
		System.out.println("Varyans : " + roundOff);
		double harmonikortalama;
		for(i=0;i<sayiAdedi;i++)
		{
			bolumler[i] = 1 / x[i];
		}
		double bolumlerToplam = 0;
		for(i=0;i<sayiAdedi;i++)
		{
			bolumlerToplam = bolumlerToplam + bolumler[i];
		}
		harmonikortalama = sayiAdedi / (bolumlerToplam);
		for(i=0;i<sayiAdedi;i++)
		{
			double md= x[i]-aritmetikortalama;
			if(md<0)
			{
				md = md * -1;
			}
			mdtoplam = md + mdtoplam;
		}
		oms = mdtoplam / sayiAdedi;
		oms = Math.round(oms * 100.0) / 100.0;
		double dk = oms / aritmetikortalama;
		System.out.println("Ortalama Mutlak Sapma: " + oms);
		System.out.println("Deðiþim Katsayýsý: " + dk);
		int medKadsayiAdedi = 0;
		if(sayiAdedi%2==0)
		{
			medKadsayiAdedi = (sayiAdedi/2)-1;
		}
		if(sayiAdedi%2!=0)
		{
			medKadsayiAdedi = (sayiAdedi/2-(1/2));
		}
		if(medKadsayiAdedi%2==0)
		{
			birinciceyrek = (double)(x[(medKadsayiAdedi/2)-1]+x[(medKadsayiAdedi/2)])/2;
			ikinciceyrek = (double)(x[(sayiAdedi - ((medKadsayiAdedi/2)-1))-1]+x[sayiAdedi - (medKadsayiAdedi/2)]-1)/2;
		}
		if(medKadsayiAdedi%2!=0)
		{
			birinciceyrek =(double)(x[medKadsayiAdedi/2-(1/2)]);
			ikinciceyrek = (double)(x[sayiAdedi - (medKadsayiAdedi/2-(1/2))-1]);
		}
		System.out.println("Birinci Çeyrek: " + birinciceyrek);
		System.out.println("Ýkinci Çeyrek: " + ikinciceyrek);
		double ceyreklerAcikligi = ikinciceyrek - birinciceyrek;
		System.out.println("Çeyrekler Açýklýðý: " + ceyreklerAcikligi);
		double carpiklikKatsayisi;
		for(i=0;i<sayiAdedi;i++)
		{
			double küpü = (x[i]-aritmetikortalama)*(x[i]-aritmetikortalama)*(x[i]-aritmetikortalama);
			küpüToplam = küpü + küpüToplam;
		}
		carpiklikKatsayisi = (küpüToplam/sayiAdedi)/(standartSapma*standartSapma*standartSapma);
		System.out.println("Çarpýklýk Katsayýsý: " + carpiklikKatsayisi);
		for(i=0;i<sayiAdedi;i++)
		{
			double dkuvveti = (x[i]-aritmetikortalama)*(x[i]-aritmetikortalama)*(x[i]-aritmetikortalama)*(x[i]-aritmetikortalama);
			dkuvvetiToplam = dkuvveti + dkuvvetiToplam;
		}
		double basiklikKatsayisi;
		basiklikKatsayisi = ((dkuvvetiToplam/sayiAdedi)/(standartSapma*standartSapma*standartSapma*standartSapma))-3;
		System.out.println("Basiklik Katsayisi: " + basiklikKatsayisi);
		System.out.println("Frekans Serisi: ");
		System.out.println("x1  f1");
		System.out.println(x[0] + "  " + sayisi[0]);
		for(i=1;i<sayiAdedi;i++)
		{
			if(x[i]!=x[i-1])
			{
			System.out.println(x[i] + "  " + sayisi[i]);
			System.out.println("\n");
			}
		}
		
	}
}







