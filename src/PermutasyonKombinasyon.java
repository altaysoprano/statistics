import java.util.Scanner;

public class PermutasyonKombinasyon {
	
	int ilkSayi;
	int ikinciSayi;
	
	public void PermutasyonBul()
	{
		int i, pay = 1, payda = 1, permutasyon=0;
		System.out.println("İlk Sayiyi giriniz: ");
		Scanner girdi = new Scanner(System.in);
		ilkSayi = girdi.nextInt();
		System.out.println("İkinci Sayiyi giriniz: ");
		Scanner girdi2 = new Scanner(System.in);
		ikinciSayi = girdi2.nextInt();
		
		for(i=ilkSayi;i>1;i--)
		{
			pay  = pay * i;
		}
		
		for(i=ilkSayi-ikinciSayi;i>1;i--)
		{
			payda = payda * i;
		}
		permutasyon = pay / payda;
		System.out.println("Permutasyon: " + permutasyon);
	}
	
	public void KombinasyonBul()
	{
		int i, pay = 1, payda=1, payda1 = 1, payda2 = 1, kombinasyon=0;
		System.out.println("İlk Sayiyi giriniz: ");
		Scanner girdi = new Scanner(System.in);
		ilkSayi = girdi.nextInt();
		System.out.println("İkinci Sayiyi giriniz: ");
		Scanner girdi2 = new Scanner(System.in);
		ikinciSayi = girdi2.nextInt();
		
		for(i=ilkSayi;i>1;i--)
		{
			pay = pay * i;
		}
		
		for(i=ilkSayi-ikinciSayi;i>1;i--)
		{
			payda1 = payda1 * i;
		}
		for(i=ikinciSayi;i>1;i--)
		{
			payda2 = payda2 * i;
		}
		payda = payda1 * payda2;
		System.out.println("Payda: " + payda);
		kombinasyon = pay / payda;
		System.out.println("Kombinasyon: " + kombinasyon);
	}
}
