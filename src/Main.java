import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("==명언 앱 실행==");

		int lastId = 0;
		List<WiseSaying> wiseSayings = new ArrayList<>();

		while (true) {
			System.out.print("명령어 ) ");

			String cmd = sc.nextLine();
			if (cmd.equals("등록")) {

				int id = lastId + 1;
				System.out.print("명언 : ");
				String title = sc.nextLine();
				System.out.print("작가 : ");
				String author = sc.nextLine();
				LocalDateTime currentDateTime = LocalDateTime.now();

				WiseSaying wiseSaying = new WiseSaying(author, title, id);
				wiseSayings.add(wiseSaying);

				System.out.printf("%d번 명언이 등록되었습니다\n", id);
				lastId++;
			} else if (cmd.equals("목록")) {
				System.out.println("번호  /  명언  /  작가");
				System.out.println("===========================");

				for (int i = wiseSayings.size() - 1; i >= 0; i--) {
					WiseSaying ws = wiseSayings.get(i);

					System.out.printf("%d  /  %s  /  %s\n", ws.getid(), ws.getAuthor(), ws.getTitle());
				}

			} else if (cmd.equals("종료")) {
				sc.close();
			}
		}

	}

}

class WiseSaying {
	private String title;
	private String author;
	private int id;

	public WiseSaying(String title, String author, int id) {
		this.title = title;
		this.author = author;
		this.id = id;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

}
