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
		int ZeroOrOne = 0;
		int xZeroOneCount[][] = new int[10][10];
		int yZeroOneCount[][] = new int[10][10];
		int i, j, x, y;

		//======================================================
		// Count FirstOne
		//======================================================
		for (i = 0; i < 10; i++) {
			x = 0;
			ZeroOrOne = 0; /* 0 か 1 のどちらについて数えるのか？ 最初は 0 から */
			while(x < 10 && c[i][x] == ZeroOrOne) {
				xZeroOneCount[i][0]++;
				x++;
			}
			/* ここで x の値は 0 に戻さないでそのままにする */
			ZeroOrOne = 1;
			while(x < 10 && c[i][x] == ZeroOrOne) {
				xZeroOneCount[i][1]++;
				x++;
			}
			/* ここで x の値は 0 に戻さないでそのままにする */
			ZeroOrOne = 0;
			while(x < 10 && c[i][x] == ZeroOrOne) {
				xZeroOneCount[i][2]++;
				x++;
			}
			/* ここで x の値は 0 に戻さないでそのままにする */
			ZeroOrOne = 1;
			while(x < 10 && c[i][x] == ZeroOrOne) {
				xZeroOneCount[i][3]++;
				x++;
			}
		}

		for (j = 0; j < 10; j++) {
			y = 0;
			ZeroOrOne = 0; /* 0 か 1 のどちらについて数えるのか？ 最初は 0 から */
			while(y < 10 && c[y][j] == ZeroOrOne) {
				yZeroOneCount[0][j]++;
				y++;
			}
			/* ここで x の値は 0 に戻さないでそのままにする */
			ZeroOrOne = 1;
			while(y < 10 && c[y][j] == ZeroOrOne) {
				yZeroOneCount[1][j]++;
				y++;
			}
			/* ここで x の値は 0 に戻さないでそのままにする */
			ZeroOrOne = 0;
			while(y < 10 && c[y][j] == ZeroOrOne) {
				yZeroOneCount[2][j]++;
				y++;
			}
			/* ここで x の値は 0 に戻さないでそのままにする */
			ZeroOrOne = 1;
			while(y < 10 && c[y][j] == ZeroOrOne) {
				yZeroOneCount[3][j]++;
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

			if (xZeroOneCount[y][0] < 10) {
				System.out.print(" ");
			}
			System.out.print(xZeroOneCount[y][0] + ",");

			if (xZeroOneCount[y][1] < 10) {
				System.out.print(" ");
			}
			System.out.print(xZeroOneCount[y][1] + ",");

			if (xZeroOneCount[y][2] < 10) {
				System.out.print(" ");
			}
			System.out.print(xZeroOneCount[y][2] + ",");

			if (xZeroOneCount[y][3] < 10) {
				System.out.print(" ");
			}
			System.out.print(xZeroOneCount[y][3]);

			System.out.print("\n");
		}
		System.out.print("--------------------------------------------------\n");

		for( x = 0; x < 10; x++ ) {
			if (yZeroOneCount[0][x] < 10) {
				System.out.print(" ");
			}
			System.out.print("" + yZeroOneCount[0][x] + " ");
		}
		System.out.print("\n");

		for(x = 0; x < 10; x++ ) {
			if (yZeroOneCount[1][x] < 10) {
				System.out.print(" ");
			}
			System.out.print("" + yZeroOneCount[1][x] + " ");
		}
		System.out.print("\n");

		for(x = 0; x < 10; x++ ) {
			if (yZeroOneCount[2][x] < 10) {
				System.out.print(" ");
			}
			System.out.print("" + yZeroOneCount[2][x] + " ");
		}
		System.out.print("\n");

		for(x = 0; x < 10; x++ ) {
			if (yZeroOneCount[3][x] < 10) {
				System.out.print(" ");
			}
			System.out.print("" + yZeroOneCount[3][x] + " ");
		}
		System.out.print("\n");
	}
}