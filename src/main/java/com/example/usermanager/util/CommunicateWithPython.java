package com.example.usermanager.util;

import com.example.usermanager.entity.Job;
import com.example.usermanager.entity.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class CommunicateWithPython {

    public static List<Job> getRecommendJobs(User user){
        List<Job> jobs = null;
        if(user.getUserName() == null){
            return getDefaultJobs();
        }
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
            URL url = new URL("http://localhost:/upload_resume");   //后期改
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

    public static List<Job> getDefaultJobs(){
        ArrayList<Job> jobList = new ArrayList<>();
        jobList.add(new Job("2427096294014030", "Architect",
                "Project Architects lead architectural projects, from concept to completion, coordinating design teams, managing budgets, and ensuring compliance with regulations.",
                "AES", "Architectural project management, Construction documents, Building systems, Design coordination, Client communication",
                "Singapore", "Temporary", 85000.0));

        jobList.add(new Job("188217896672379", "Customer Support Specialist",
                "Customer Success Managers focus on ensuring customer satisfaction and retention. They build relationships with clients, understand their needs, and work to maximize the value customers receive from products or services, ultimately driving customer success and loyalty.",
                "CRH (China Resources Holdings)", "Customer relationship management, Onboarding and training, Customer feedback analysis, Retention strategies, Cross-selling and upselling, Strong communication and empathy, Customer advocacy",
                "Singapore", "Part-Time", 82000.0));

        jobList.add(new Job("1969594223159390", "Event Planner",
                "Event Coordinators plan and execute various events, including conferences, parties, and meetings, managing logistics, budgets, and vendor relationships.",
                "McKesson", "Event planning, Vendor coordination, Budget management, Marketing and promotion, Logistics",
                "Singapore", "Full-Time", 76000.0));

        jobList.add(new Job("758386065169133", "Software Engineer",
                "DevOps Engineers focus on automating and streamlining the development and deployment processes. They work to improve collaboration between development and IT operations, implementing tools and practices for continuous integration and continuous delivery (CI/CD).",
                "Iluka Resources", "Automation and scripting (e.g., Python, Bash), Continuous Integration/Continuous Deployment (CI/CD), Containerization (e.g., Docker, Kubernetes), Infrastructure as Code (e.g., Terraform, Ansible), Cloud platforms (e.g., AWS, Azure, GCP), Monitoring and troubleshooting skills",
                "Singapore", "Full-Time", 83000.0));

        jobList.add(new Job("659329208135258", "Data Engineer",
                "A Big Data Engineer develops and manages big data solutions, including data storage, processing, and analysis platforms, to extract valuable insights and support data-driven decisions.",
                "Salesforce", "Big data technologies (Hadoop, Spark, etc.), Data processing and analysis, Distributed computing",
                "Singapore", "Contract", 73000.0));

        jobList.add(new Job("2053710386235246", "Art Director",
                "An Art Curator is responsible for managing and preserving a collection of artworks. They curate exhibitions, acquire new pieces, and educate the public about the art.",
                "WESCO International", "Art history and knowledge, Art curation and exhibition planning, Collections management, Art market trends, Cultural awareness",
                "Singapore", "Full-Time", 91500.0));

        jobList.add(new Job("1673964364335675", "Veterinarian",
                "A Small Animal Veterinarian provides medical care to small pets, such as dogs and cats. They diagnose illnesses, perform surgeries, and advise pet owners on healthcare practices.",
                "China Telecom", "Veterinary medicine, Small animal care and surgery, Animal diagnostics, Preventive medicine, Client communication, Surgical skills, Radiology, Anesthesia, Laboratory diagnostics, Compassion and empathy, Problem-solving, Attention to detail",
                "Singapore", "Full-Time", 88000.0));

        return jobList;
    }
}
