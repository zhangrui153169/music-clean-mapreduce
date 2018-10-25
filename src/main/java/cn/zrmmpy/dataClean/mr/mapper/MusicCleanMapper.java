package cn.zrmmpy.dataClean.mr.mapper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import cn.zrmmpy.dataClean.mr.writable.MusicWritable;


public class MusicCleanMapper extends Mapper<LongWritable, Text, NullWritable, Text> {


    private String[] fields;
    DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd"); 
    private String songid;//歌曲编号
    private String songname;//歌曲名字
    private Date releasedate;//出版时间
    private String singer;//歌曲作者
    private String picture;//歌曲图片
    private String averating;//歌曲评分
    private String description;//歌曲短评
    private String categoryid;//分类编号
    private String link;//歌曲链接
    
    @Override
    protected void setup(Context context) throws IOException,   InterruptedException {
       
    }


    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        fields = value.toString().split("@@");
        if (fields == null || fields.length<8) { // 有异常数据
            return;
        }
        songname = fields[0];
        singer = fields[1];
        try {
			releasedate=format1.parse(fields[2]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        categoryid=fields[3];
        picture = fields[4];
        averating = fields[5];
        link = fields[6];
        description = fields[7];
        songid = link.split("/")[4];
        MusicWritable access = new MusicWritable(songid, songname,releasedate, singer,picture,averating,
    			description,categoryid,link);
        context.write(NullWritable.get(), new Text(access.toString()));
    }


}
