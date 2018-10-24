package cn.zrmmpy.dataClean.mr.mapper;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import cn.zrmmpy.dataClean.mr.writable.MusicWritable;


public class MusicCleanMapper extends Mapper<LongWritable, Text, NullWritable, Text> {


    private String[] fields;
    private Integer musicid;//歌曲编号
    private String songname;//歌曲名字
    private String singer;//歌曲作者
    private String picture;//歌曲图片
    private Integer averating;//歌曲评分
    private String description;//歌曲短评
    private Integer categoryid;//分类编号
    private String link;//歌曲链接
    
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        musicid = Integer.getInteger(link.split("\\")[4]);
    }


    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        fields = value.toString().split("\n");
        if (fields == null || fields.length != 10) { // 有异常数据
            return;
        }
        songname = fields[0];


        singer = fields[1];
        picture = fields[2];
        averating = Integer.valueOf(fields[3]);
        link = fields[4];

        description = fields[5];

        MusicWritable access = new MusicWritable(musicid, songname,singer,picture,averating,
    			description,categoryid,link);
        context.write(NullWritable.get(), new Text(access.toString()));
    }


}
