package cn.zrmmpy.dataClean.mr.reducer;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MusicCleanReducer extends Reducer<NullWritable, Text, NullWritable, Text>{
	@Override
	protected void reduce(NullWritable key, Iterable<Text> values, Context context)
			throws IOException, InterruptedException 
	{
		StringBuffer musics = new StringBuffer();
		for(Text musicinfo : values){
			musics.append(musicinfo+";");
		}
		context.write(NullWritable.get() , new Text(musics.toString()));			
	}

}
