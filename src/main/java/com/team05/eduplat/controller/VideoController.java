package com.team05.eduplat.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import net.sf.json.JSONObject;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;


@RestController
@RequestMapping("/video")
public class VideoController {
    @Value("${prop.upload-folder}")
    String uploadFolder;

    @ApiOperation("视频上传")
    @PostMapping("/upload")
    public void VideoUpload(@RequestParam(value="file")MultipartFile file, @RequestParam(value="guid")String guid){
        if (!file.isEmpty()) {
            try {
                String path = uploadFolder + "/" + guid;
                File tempDir = new File(path);//暂存文件夹
                if(!tempDir.exists()){
                    tempDir.mkdirs();
                }
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(
                                new File(tempDir, file.getOriginalFilename() + ".part")));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @ApiOperation("视频合并")
    @GetMapping("/merge")
    public void VideoMerge(String guid) throws IOException {
        System.out.println(guid);
        String path = uploadFolder + "/" + guid;
        File tempDir = new File(path);
        Date curTime = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
        String time = simpleDateFormat.format(curTime);
        if(tempDir.isDirectory()) {
            String targetPath = uploadFolder + "/" + time;
            File targetDir = new File(targetPath);
            if (!targetDir.exists()) {
                targetDir.mkdirs();
            }
            //开始合并
            File targetFile = new File(targetPath, guid + ".webm");
            FileChannel targetChannel = new FileOutputStream(targetFile, true).getChannel();
            int fileNums = tempDir.listFiles().length;
            for (int i = 0; i < fileNums; i++) {
                File partFile = new File(tempDir, guid + "_" + i + ".part");
                FileChannel partChannel = new FileInputStream(partFile).getChannel();
                targetChannel.transferFrom(partChannel, targetChannel.size(), partChannel.size());
                partChannel.close();
                partFile.delete();
            }
            tempDir.delete();
            targetChannel.close();
        }
    }
}
