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
		
		/* 解説:
			「今見ている座標の数字が0なのか、1なのか」で判定を行う。
			まずは一番外のfor文は無視して、中の処理を確認する。
			一個内側のwhileから見ていくと、
			最初、ZeroOrOneが0なら1に、1なら0に、と変換している。
			次のwhile文内では
			「xが入力データの配列の端っこではない」
			かつ
			「ZeroOrOneと入力データの配列の中身が一緒」の時
			ｘZeroOneCountをインクリメントしている。
			
			2個目のwhileは、同一行に対して
			1つ左のものと今見ている者が同じものであれば個数をカウントして
			座標を一つ右にずらす処理。
			もし1個右にずらして、前の状態と別のものが来たら2個目の(一番内側の)whileを終了させ、
			1つ上のWhileに戻ってくる。
			ZeroOrOneの値を切り替えて、再度上記のWhileを繰り返す...という処理を
			各行に行うことで、すべての行の0,1の個数をとれるようにしている。
		*/
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

			for (i = 0; i < 10; i++) {
				if (xZeroOneCount[y][i] < 10) {
					System.out.print(" ");
				}
				if (i != 9) { // 右に表示する部分で、一番端っこは「,」がいらないから取り除く処理
					System.out.print(xZeroOneCount[y][i] + ",");
				} else {
					System.out.print(xZeroOneCount[y][i]);
				}
			}
			System.out.print("\n");
		}
		System.out.print("------------------------------------------------------------------\n");

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