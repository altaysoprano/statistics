import java.util.Random;
import java.util.Scanner;

public class orneklemeler {
	int N, n, k, i, max, min, v, a, b;
	public void sistematikhesapla()
	{
		System.out.println("Evrenin hacmini giriniz: ");
		Scanner girdi = new Scanner(System.in);
		N = girdi.nextInt();
		System.out.println("�rneklem hacmini giriniz: ");
		Scanner girdi2 = new Scanner(System.in);
		n = girdi2.nextInt();
		k = N/n;
		Random r=new Random(); //random s�n�f�
		int a=r.nextInt(k);
		System.out.println("Sistematik Rastgele �rnekleme:\n");
		System.out.println(a);
		for(i=0;i<n-1;i++)
		{
			System.out.println(a+k);
			k=k*2;
		}
	}
	public void basitHesapla()
	{
		System.out.println("Maksimum Say�y� Giriniz: ");
		Scanner girdi = new Scanner(System.in);
		 max = girdi.nextInt();
		System.out.println("Minimum Say�y� giriniz: ");
		Scanner girdi2 = new Scanner(System.in);
		 min = girdi2.nextInt();
		 v = (max-min)+1;
		Random r=new Random(); //random s�n�f�
		 b=r.nextInt(v);
		System.out.println("Sayi: " + b);
	}
}
