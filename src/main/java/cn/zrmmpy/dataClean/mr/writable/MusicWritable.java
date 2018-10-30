package cn.zrmmpy.dataClean.mr.writable;

import java.util.Date;

public class MusicWritable {
    private String songid;//歌曲编号
    private String songname;//歌曲名字
    private Date releasedate;//出版时间
    private String singer;//歌曲作者
    private String picture;//歌曲图片
    private String averating;//歌曲评分
    private String description;//歌曲短评
    private String categoryid;//分类编号
    private String link;//歌曲链接

	public MusicWritable(String songid, String songname, Date releasedate, String singer, String picture,
			String averating, String description, String categoryid, String link) {
		super();
		this.songid = songid;
		this.songname = songname;
		this.releasedate = releasedate;
		this.singer = singer;
		this.picture = picture;
		this.averating = averating;
		this.description = description;
		this.categoryid = categoryid;
		this.link = link;
	}

	@Override
	public String toString() {
		return songid + "@@" + songname + "@@" + releasedate
				+ "@@" + singer + "@@" + picture + "@@" + averating + "@@"
				+ description + "@@" + categoryid + "@@" + link;
	}

	
}
