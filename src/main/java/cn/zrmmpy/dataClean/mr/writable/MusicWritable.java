package cn.zrmmpy.dataClean.mr.writable;


public class MusicWritable {
    private Integer musicid;//歌曲编号
    private String songname;//歌曲名字
    private String singer;//歌曲作者
    private String picture;//歌曲图片
    private Integer averating;//歌曲评分
    private String description;//歌曲短评
    private Integer categoryid;//分类编号
    private String link;//歌曲链接
	public MusicWritable(Integer musicid, String songname, String singer, String picture, Integer averating,
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
	@Override
	public String toString() {
		return "MusicWritable [musicid=" + musicid + ", songname=" + songname + ", singer=" + singer + ", picture="
				+ picture + ", averating=" + averating + ", description=" + description + ", categoryid=" + categoryid
				+ ", link=" + link + "]";
	}
}
