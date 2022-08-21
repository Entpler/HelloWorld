package com.kh.chap01.list.part02.mvc.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.chap01.list.part02.mvc.comtroller.MusicController;
import com.kh.chap01.list.part02.mvc.model.vo.Music;

//View : �ð����� ���(����ڰ� ���� �� ȭ��)
//       ��¹��� �Է¹��� ���
public class MusicView {
//����ڰ� ���α׷� ���۽� ���� ó�� �������� ȭ�� 
//=>����ȭ�� 

	// �������� //��ĳ�� ��𼭵��� ���Բ�

	private Scanner in = new Scanner(System.in);
	private MusicController mc = new MusicController();

	public void mainMenu() {
		while (true) {
			System.out.println("*** Welcom ���� ***");
			System.out.println("1. ���ο� �� �߰�");
			System.out.println("2. �� ��ü ��ȸ");
			System.out.println("3. Ư�� �� �˻�");
			System.out.println("4. Ư�� �� ����"); // remove
			System.out.println("5. Ư���� ����");
			System.out.println("0. ���α׷� ����");

			System.out.println("----------------------------");

			System.out.print("�޴� �Է�: ");
			int menu = in.nextInt();
			in.nextLine();

			switch (menu) {

			case 1:
				inserMusic(); // ���� Ŭ������ �޼ҵ�� �׳� ȣ�� �Ǹ��.
				break;
			case 2:
				selecMusicList();
				break;
			case 3:
				searchMusic();
				break;
			case 4:
				deleteMusic();
				break;
			case 5:
				updateMusic();
				break;
			case 0:
				System.out.println("���α׷��� �����մϴ�.");
				return;
			default:
				System.out.println("�߸��� �޴��Դϴ�.�ٽ� �Է����ּ���");
			}
		}

	}

	// 1. ���ο� ���� �߰���ų �� �ִ� ȭ�� ����ϴ� �޼ҵ�.
	public void inserMusic() {

		System.out.println("==���ο� �� �߰�==");
		System.out.print("��� �Է�: ");
		String title = in.nextLine();
		System.out.print("������ �Է� : ");
		String artist = in.nextLine(); // ��¹��� �Է¹��̴ϱ� �޼ҵ�� ����.
		// �߰����ּ��� ��û => controller Ŭ������ �޼ҵ带 ȣ���ؼ� ��û�� ó���ϵ���

		mc.inserMusic(title, artist);
		System.out.println("���������� �߰��Ǿ����ϴ�.");

	}

	public void selecMusicList() {
		// ��ü�ý�Ʈ�� ��ȸ�� �ּ��� ��û=>Controller Ŭ������ �޼ҵ� ȣ��

		System.out.println("==�� ��ü ��ȸ==");
		ArrayList<Music> list = mc.selectMusicList();
		if (list.isEmpty()) {
			System.out.println("���� �����ϴ� ���� �����ϴ�.");

		} else {// ����Ʈ�� ������� ���� ���
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
	}

	// 3.Ư�� ���� �˻��� �� �ִ� ȭ��
	public void searchMusic() {
		System.out.println("==Ư�� �� �˻�==");
		System.out.print("�˻��� ��� Ű����:");
		String keyword = in.nextLine();

		// �˻����ּ��� =>Controller Ŭ������ �޼ҵ� ȣ��
		ArrayList<Music> searched = mc.searchMusic(keyword);

		// �˻���� ���

		System.out.println("�˻����: ");

		if (searched.isEmpty()) {
			System.out.println("�˻������ �����ϴ�.");
		} else {

			for (Music m : searched) {
				System.out.println(m);
			}

		}
	}

	// 4.Ư�� ���� ������ �� �ִ� ȭ��

	public void deleteMusic() {
		System.out.println("==Ư�� �� ����==");
		System.out.print("������ ���:");
		String title = in.nextLine();
		// ������ �ּ��� ��û => ContollerŬ������ �޼ҵ�

		int result = mc.deleteMusic(title);

		if (result > 0) {// �����= ������ �����
			System.out.println("���������� �����Ǿ����ϴ�.");

		} else {// ������ ���� ã������.
			System.out.println("������ ���� ã�� ���߽��ϴ�.");

		}
	}

	// 5.
	public void updateMusic() {
		System.out.println("==Ư�� �� ����==");
		//���� ��� �����ؾ��ϴ��� ���
		//�������,�����Ұ��,������ ������ �Է¹ޱ�
		System.out.print("���� ��� :");
		String title =in.nextLine();
		
		System.out.print("��������(���):");
		String upTitle = in.nextLine();
		
		System.out.print("��������(������):");
		String upArtist = in.nextLine();
		
		//�������ּ��� ��û - >Controller Ŭ������ �޼ҵ� ȣ��
		//�������θ� ���Ϲޱ�(int)
		int result = mc.updateMusic(title, upTitle, upArtist);
		if(result>0) { //������ �����
			System.out.println("���������� �����Ǿ����ϴ�.");
			
		}else { //������ ���� ã�� ����
			System.out.println("������ ���� ã�� ���߽��ϴ�.");
			
		}
	}

}
