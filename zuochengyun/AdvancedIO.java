package zuochengyun;

// 快速输入输出
// 使用 StreamTokenizer 进行输入 使用 PrintWriter 进行输出 避免使用 Scanner 和 System.out.println
// 使用全局静态空间
// 更进一步 https://github.com/algorithmzuo/algorithm-journey/tree/main/src/class019

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class AdvancedIO {
    // 给定行数和列数 读取数字矩阵
    public static int MAXN = 100;
    public static int MAXM = 100;
    public static int n, m;
    public static int[][] mat = new int[MAXN][MAXM];

	public static void readNumber(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new StreamTokenizer(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			n = (int) in.nval;  // 读取行数
			in.nextToken();  // 跳过空格ß
			m = (int) in.nval;  // 读取列数

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					in.nextToken();
					mat[i][j] = (int) in.nval;
				}
			}

			out.println();  // 调用处理逻辑的方法
		}

		out.flush();
		br.close();
		out.close();
	}

    // 按行读取字符串
    public static String line;  // 读取的整行字符串
	public static String[] parts;  // 按空格分割后的字符串数组

    public static void readLines(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		while ((line = in.readLine()) != null) {
			parts = line.split(" ");  // 按空格分割字符串
			
            for (String num : parts) {
				// 处理每个单词
			}
			
            out.println();  // 输出计算结果
		}
		
        out.flush();
		in.close();
		out.close();
    }
}