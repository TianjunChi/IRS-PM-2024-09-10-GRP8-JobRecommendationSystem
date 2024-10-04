package com.example.usermanager.util;

import com.example.usermanager.entity.Job;
import com.example.usermanager.entity.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class CommunicateWithPython {
    public static List<Job> getRecommendJobs(User user){
        List<Job> jobs = null;
        try {
            // Python 端的 API 地址
            URL url = new URL("http://localhost:5000/recommend_jobs");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            // 使用 Jackson 将 User 对象转换为 JSON
            ObjectMapper mapper = new ObjectMapper();
            String jsonInputString = mapper.writeValueAsString(user);

            // 发送 JSON 数据
            conn.getOutputStream().write(jsonInputString.getBytes("UTF-8"));
            conn.getOutputStream().flush();

            // 检查响应码
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP POST 请求失败，响应码为 : " + conn.getResponseCode());
            }

            // 读取响应数据
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                response.append(output);
            }
            conn.disconnect();

            // 使用 Jackson 解析 JSON
            jobs = mapper.readValue(response.toString(), new TypeReference<List<Job>>() {});

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jobs;
    }


    public static User readFromResume(File pdfFile){
        User user = null;
        try {
            // Python 端的 API 地址
            URL url = new URL("http://localhost:5000/upload_resume");   //后期改
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=--boundary");

            // 发送 PDF 文件
            try (OutputStream os = conn.getOutputStream();
                 FileInputStream fis = new FileInputStream(pdfFile)) {
                os.write(("--boundary\r\n" +
                        "Content-Disposition: form-data; name=\"file\"; filename=\"" + pdfFile.getName() + "\"\r\n" +
                        "Content-Type: application/pdf\r\n\r\n").getBytes());

                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }

                os.write("\r\n--boundary--\r\n".getBytes());
                os.flush();
            }

            // 检查响应码
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP POST 请求失败，响应码为 : " + conn.getResponseCode());
            }

            // 读取响应数据
            ObjectMapper mapper = new ObjectMapper();
            user = mapper.readValue(conn.getInputStream(), User.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return user;
    }
}
