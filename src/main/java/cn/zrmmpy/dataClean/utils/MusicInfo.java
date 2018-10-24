package cn.zrmmpy.dataClean.utils;


public class MusicInfo {
    private Integer musicid;//歌曲编号
    private String songname;//歌曲名字
    private String singer;//歌曲作者
    private String picture;//歌曲图片
    private Integer averating;//歌曲评分
    private String description;//歌曲短评
    private Integer categoryid;//分类编号
    private String link;//歌曲链接

    public MusicInfo(){}

	public MusicInfo(Integer musicid, String songname, String singer, String picture, Integer averating,
			String description, Integer categoryid, String link) {
		super();
		this.musicid = musicid;
		this.songname = songname;
		this.singer = singer;
		this.picture = picture;
		this.averating = averating;
		this.description = description;
		this.categoryid = categoryid;
		this.link = link;
	}

	public Integer getMusicid() {
		return musicid;
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

	public Integer getAverating() {
		return averating;
	}

	public String getDescription() {
		return description;
	}

	public Integer getCategoryid() {
		return categoryid;
	}

	public String getLink() {
		return link;
	}



}