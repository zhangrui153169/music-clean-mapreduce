package cn.zrmmpy.dataClean.utils;

import java.util.Date;

public class MusicInfo {
    private String songid;//歌曲编号
    private String songname;//歌曲名字
    private Date releasedate;//出版时间
    private String singer;//歌曲作者
    private String picture;//歌曲图片
    private String averating;//歌曲评分
    private String description;//歌曲短评
    private String categoryid;//分类编号
    private String link;//歌曲链接

    public MusicInfo(){}


	public MusicInfo(String musicid, String songname, Date releasedate, String singer, String picture,
			String averating, String description, String categoryid, String link) {
		super();
		this.songid = musicid;
		this.songname = songname;
		this.releasedate = releasedate;
		this.singer = singer;
		this.picture = picture;
		this.averating = averating;
		this.description = description;
		this.categoryid = categoryid;
		this.link = link;
	}


	public String getMusicid() {
		return songid;
	}

	public String getSongname() {
		return songname;
	}

	public String getSinger() {
		return singer;
	}

	public String getPicture() {
		return picture;
	}

	public String getAverating() {
		return averating;
	}

	public String getDescription() {
		return description;
	}

	public String getCategoryid() {
		return categoryid;
	}

	public String getLink() {
		return link;
	}

	public Date getReleasedate() {
		return releasedate;
	}





}