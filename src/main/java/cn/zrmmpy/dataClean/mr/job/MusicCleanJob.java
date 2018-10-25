package cn.zrmmpy.dataClean.mr.job;


import cn.zrmmpy.dataClean.mr.mapper.MusicCleanMapper;
import cn.zrmmpy.dataClean.mr.reducer.MusicCleanReducer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

/**
 * 清洗音乐信息
 * 主要的驱动程序
 *      主要用作组织mapper和reducer的运行
 *
 * 输入参数：
 * 如：hdfs://ns1/input/data-clean/access/2018/04/08 hdfs://ns1/output/data-clean/access
 * 即inputPath和outputPath
 * 目前outputPath统一到			???????


 */
public class MusicCleanJob {
    public static void main(String[] args) throws Exception {

        if(args == null || args.length < 2) {
            System.err.println("Parameter Errors! Usage <inputPath...> <outputPath>");
            System.exit(-1);
        }

        Path outputPath = new Path(args[args.length - 1]);

        Configuration conf = new Configuration();
        String jobName = MusicCleanJob.class.getSimpleName();
        Job job = Job.getInstance(conf, jobName);
        job.setJarByClass(MusicCleanJob.class);

        // 设置mr的输入参数
        for( int i = 0; i < args.length - 1; i++) {
            FileInputFormat.addInputPath(job, new Path(args[i]));
        }
        job.setInputFormatClass(TextInputFormat.class);
        job.setMapperClass(MusicCleanMapper.class);
        job.setMapOutputKeyClass(NullWritable.class);
        job.setMapOutputValueClass(Text.class);
        // 设置mr的输出参数
        outputPath.getFileSystem(conf).delete(outputPath, true);    // 避免job在运行的时候出现输出目录已经存在的异常
        FileOutputFormat.setOutputPath(job, outputPath);
        job.setOutputFormatClass(TextOutputFormat.class);

        job.setReducerClass(MusicCleanReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        job.setNumReduceTasks(1);

        job.waitForCompletion(true);
    }
}
