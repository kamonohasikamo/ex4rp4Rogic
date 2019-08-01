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
		int xZeroOneCount[][] = new int[10][11]; // 表示の最後の「,」をそろえるために1つ大きめに作成
		int yZeroOneCount[][] = new int[10][10];
		int i, j, x, y;

		//======================================================
		// Count FirstOne
		//======================================================
		for (i = 0; i < 10; i++) {
			x = 0;
			ZeroOrOne = 1; /* 0 か 1 のどちらについて数えるのか？ 最初は 0 から */
			j = 0;
			while (j <= 10) {
				if (ZeroOrOne == 0) { // ここで最初 1 -> 0 に切り替わる
					ZeroOrOne = 1;
				} else {
					ZeroOrOne = 0;
				}
				while (x < 10 && c[i][x] == ZeroOrOne) {
					xZeroOneCount[i][j]++;
					x++;
				}
				j++;
			}
		}

		// yについても、xと同様にやっていく
		for (i = 0; i < 10; i++) {
			y = 0;
			ZeroOrOne = 1; /* 0 か 1 のどちらについて数えるのか？ 最初は 0 から */
			j = 0;
			while (j <= 10) {
				if (ZeroOrOne == 0) { // ここで最初 1 -> 0 に切り替わる
					ZeroOrOne = 1;
				} else {
					ZeroOrOne = 0;
				}
				while (y < 10 && c[y][i] == ZeroOrOne) {
					yZeroOneCount[j][i]++;
					y++;
				}
				j++;
			}
		}

		//======================================================
		// ShowRogic
		//======================================================
		/* 
			解説(2019/8/1追記)
			まずは行の表記を左側にする作業から。
			左にするということは、
			「0の部分に対して予め空白を入れておき」
			そのあと今までの表示を行う。という指針で処理する。
			なので、今までの表示の前に1つfor文を追加した。
		*/
		for( y = 0; y < 10; y++ ) {
			for (i = 9; i > -1; i--) {
				if (xZeroOneCount[y][i] == 0) {
					System.out.print("   ");
				} else {
					break;
				}
			}
			for (i = 0; i < 10; i++) {
				if (xZeroOneCount[y][i] != 0) {
					if (xZeroOneCount[y][i] < 10) {
						System.out.print(" ");
					}
					System.out.print(xZeroOneCount[y][i]);
					if (xZeroOneCount[y][i + 1] != 0) {
						System.out.print(",");
					}
				}
			}
			System.out.print(" || ");
			for( x = 0; x < 10; x++ ) {
				System.out.print(" " + c[y][x] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("------------------------------------------------------------------\n");
		int isEmptyCount = 0;

		for (i = 0; i < 10; i++) {
			for( x = 0; x < 10; x++ ) {
				if (yZeroOneCount[i][x] != 0) {
					if (yZeroOneCount[i][x] < 10) {
						System.out.print(" ");
					}
					System.out.print("" + yZeroOneCount[i][x] + " ");
				} else {
					isEmptyCount++;
					if (isEmptyCount < 10) {
						System.out.print("   ");
					} else {
						System.exit(0);
					}
				}
			}
			isEmptyCount = 0;
			System.out.print("\n");
		}
	}
}