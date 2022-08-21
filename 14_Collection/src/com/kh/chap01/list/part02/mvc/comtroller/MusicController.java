package com.kh.chap01.list.part02.mvc.comtroller;

import java.util.ArrayList;

import com.kh.chap01.list.part02.mvc.model.vo.Music;

public class MusicController {
//���ο� �� �߰� ��û �� ���� �� �޼ҵ�
	ArrayList<Music> list = new ArrayList<>();
	{
		// �ʱ�ȭ ��� //�޼ҵ�� �ƴϰ� ���ϴ� ���� ���� �ϰ� ������.

		list.add(new Music("that,taht", "����"));
		list.add(new Music("��Ÿ������", "BTS"));

	}

//������ ������ �� �ִ� ����Ҹ� ���������� ����.
	public void inserMusic(String title, String artist) {
		list.add(new Music(title, artist));
	}

	// ��ü �� ��ȸ ��û �� ����� �޼ҵ�

	public ArrayList<Music> selectMusicList() {// ����Ʈ�� ������� ���
		return list;
	}

	// Ư�� �� �˻� ��û�� ����� �޼ҵ�

	public ArrayList<Music> searchMusic(String keyword) {

		// �˻���� :�ش� Ű���尡 ���Ե� �͵��� ��� ��ȸ

		// 1.�˻��� ������� ���� ���� ����
		// (����� 0���� ���� �ְ�, 1���� ���� �ְ�, 2��, ������ �ϼ��� ����)

		ArrayList<Music> searched = new ArrayList<>(); // ���� �� ����
		// �ݺ����� �������� ��ġ�ϴ°��� �ƴ϶� ���Ե� ���� �ִ��� �˻��ؾ���.
		for (int i = 0; i < list.size(); i++) {
			// ���ڿ��� ��ġ���踦 �˻��� �� �ִ� �޼ҵ� :equals()
			// ���ڿ��� ���԰��踦 �˻��� �� �ִ� �޼ҵ�:���ڿ�.contains(�˻��� ���ڿ�)
			// =>���ڿ� �ȿ� �˻��� ���ڿ��� ���ԵǾ��ִٸ� true, �ƴ϶�� false����
			if (list.get(i).getTitle().contains(keyword)) {
				searched.add(list.get(i));

			}
		}
		return searched;
	}
	// =>���Ե� ���빰�̶�� �˻��� ������� ���� �� �ִ� ������ ��Ƶα�

	// 3.�˻��� ����� View������ �����ϱ�

	// 4.Ư�� �� ������ ����� �޼ҵ�
	public int deleteMusic(String title) {
		int result = 0; // ������ ����� ������ ��Ÿ���� ����

		// �ݺ����� ���� �� ������ ��Ȯ�� ��ġ�ϴ��� �˻�
		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getTitle().equals(title)) { // �� ������ ��ġ�Ѥ���
				list.remove(i--); // ������ ��ĭ�� ���ܿð��� ����Ͽ� ���������� �߰�
				result++;

			}
		}
		// result return
		return result; // 0�ϼ��� �ְ�(�����Ȱ� ���� ���), �����(�����Ȱ� ���� �������) �ϼ��� ����.
	}
	// Ư�� �� ������ ��û�� ������ �޼ҵ�

	public int updateMusic(String title, String upTitle, String upArtist) {

		// 1. ������ �� ������ �޾Ƴ� �� �ִ� ������ ����
		int result = 0;

		// 2. �ݺ����� ���� ������ ��ġ�ϴ��� �˻� �� ��ġ�Ѵٸ� �� ������ ����
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().equals(title)) { // ������ ��ġ�Ѵٸ�

				/*
				 * //�����ϴ� ��� 2���� //���� ȿ����->�ʵ尪�� �ٲ�ġ��. list.get(i).setTitle(upTitle);
				 * list.get(i).setArtist(upArtist);
				 */
				// 2.���� ȿ������ ����� �ƴ����� ���� ��� ������ Ȱ���� �� ����.
				// set: ���°�� ��� �ٲ�ġ�� �Ұ��ΰ�
				list.set(i, new Music(upTitle, upArtist)); // new ���� ���� heap ������ �� �޸𸮿� �Ҵ�Ǳ� ��.

				result++;

			}
		}

		return result;
		// 3. ��� ��ȯ

	}

}
