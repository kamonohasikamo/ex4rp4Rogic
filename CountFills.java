public class CountFills {
	public static void main(String args[]) {

		int c[][] = { {0,0,0,0,0,0,0,0,0,0},
									{0,1,1,1,1,1,1,1,1,0},
									{0,0,0,0,0,0,0,1,0,0},
									{0,0,1,1,1,1,0,1,0,0},
									{0,0,1,0,0,1,0,1,0,0},
									{0,0,1,1,1,1,0,1,0,0},
									{0,0,0,0,0,0,0,1,0,0},
									{0,0,0,0,0,0,1,1,0,0},
									{0,0,0,0,0,0,0,1,0,0},
									{0,0,0,0,0,0,0,0,0,0} };
		int xcount[] = new int[10];
		int ycount[] = new int[10];
		int x,y;
		
		xcount[0] = 0;
		xcount[1] = 8;
		xcount[2] = 1;
		xcount[3] = 5;
		xcount[4] = 3;
		xcount[5] = 5;
		xcount[6] = 1;
		xcount[7] = 2;
		xcount[8] = 1;
		xcount[9] = 0;

		ycount[0] = 0;
		ycount[1] = 1;
		ycount[2] = 4;
		ycount[3] = 3;
		ycount[4] = 3;
		ycount[5] = 4;
		ycount[6] = 2;
		ycount[7] = 8;
		ycount[8] = 1;
		ycount[9] = 0;
		
		for( y = 0; y < 10; y++ ) {
				for( x = 0; x < 10; x++ ) {
						System.out.print("" + c[y][x] + " ");
				}
				System.out.print(" || " + xcount[y]);
				System.out.print("\n");
		}
		System.out.print("-------------------------\n");
		for( x = 0; x < 10; x++ ) {
				System.out.print("" + ycount[x] + " ");
		}
		System.out.print("\n");
	}
}