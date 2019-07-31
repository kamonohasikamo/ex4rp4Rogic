public class CountFills {
	public static void main(String args[]) {
		//======================================================
		// Input Data
		//======================================================
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
		
		//======================================================
		// Count variable
		//======================================================
		int xZeroCount[] = new int[10];
		int yZeroCount[] = new int[10];
		int xNextOneCount[] = new int[10];
		int yNextOneCount[] = new int[10];
		int xNextZeroCount[] = new int[10];
		int yNextZeroCount[] = new int[10];
		int i, j, x,y;

		//======================================================
		// Count FirstOne
		//======================================================
		for (i = 0; i < 10; i++) {
			x = 0;
			while(x < 10 && c[i][x] == 0 ) {
				xZeroCount[i]++;
				x++;
			}
			/* ここで x の値は 0 に戻さないでそのままにする */
			while(x < 10 && c[i][x] == 1 ) {
				xNextOneCount[i]++;
				x++;
			}
			/* ここで x の値は 0 に戻さないでそのままにする */
			while(x < 10 && c[i][x] == 0) {
				xNextZeroCount[i]++;
				x++;
			}
		}

		for (j = 0; j < 10; j++) {
			y = 0;
			while(y < 10 && c[y][j] == 0 ) {
				yZeroCount[j]++;
				y++;
			}
			/* ここで x の値は 0 に戻さないでそのままにする */
			while(y < 10 && c[y][j] == 1 ) {
				yNextOneCount[j]++;
				y++;
			}
			/* ここで x の値は 0 に戻さないでそのままにする */
			while(y < 10 && c[y][j] == 0) {
				yNextZeroCount[j]++;
				y++;
			}
		}
		

		
		//======================================================
		// ShowRogic
		//======================================================
		for( y = 0; y < 10; y++ ) {
			for( x = 0; x < 10; x++ ) {
				System.out.print(" " + c[y][x] + " ");
			}
			System.out.print(" || ");

			if (xZeroCount[y] < 10) {
				System.out.print(" ");
			}
			System.out.print(xZeroCount[y] + ",");

			if (xNextOneCount[y] < 10) {
				System.out.print(" ");
			}
			System.out.print(xNextOneCount[y] + ",");

			if (xNextZeroCount[y] < 10) {
				System.out.print(" ");
			}
			System.out.print(xNextZeroCount[y]);
			System.out.print("\n");
		}
		System.out.print("----------------------------------------------\n");

		for( x = 0; x < 10; x++ ) {
			if (yZeroCount[x] < 10) {
				System.out.print(" ");
			}
			System.out.print("" + yZeroCount[x] + " ");
		}
		System.out.print("\n");

		for(x = 0; x < 10; x++ ) {
			if (yNextOneCount[x] < 10) {
				System.out.print(" ");
			}
			System.out.print("" + yNextOneCount[x] + " ");
		}
		System.out.print("\n");

		for(x = 0; x < 10; x++ ) {
			if (yNextZeroCount[x] < 10) {
				System.out.print(" ");
			}
			System.out.print("" + yNextZeroCount[x] + " ");
		}
		System.out.print("\n");
	}
}