package com.kh.chap01.list.part02.mvc.model.vo;

public class Music {



		private String title; // 노래제목
		private String artist; // 가수명

		// 생성자

		public Music() {

		}

		public Music(String title, String artist) {
			super();
			this.title = title;
			this.artist = artist;
		}

		// 메소드부

		public String getTitle() {
			return title;
		}



		public void setTitle(String title) {
			this.title = title;
		}

		public String getArtist() {
			return artist;
		}

		public void setArtist(String artist) {
			this.artist = artist;
		}

		
		@Override
		public String toString() {
			return "Music [title=" + title + ", artist=" + artist + "]";
		}
	}


	
	
	
	
	
