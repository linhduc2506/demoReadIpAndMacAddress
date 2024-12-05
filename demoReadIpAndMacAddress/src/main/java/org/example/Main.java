package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            // Phát hiện hệ điều hành
            String os = System.getProperty("os.name").toLowerCase();
            Process process;

            if (os.contains("win")) {
                // Windows: sử dụng lệnh ipconfig /all để lấy IP và MAC
                process = Runtime.getRuntime().exec("cmd.exe /c ipconfig /all");
            } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
                // Unix/Linux/MacOS: sử dụng lệnh ifconfig hoặc ip a
                process = Runtime.getRuntime().exec("ifconfig");
            } else {
                System.out.println("Hệ điều hành không được hỗ trợ.");
                return;
            }

            // Đọc kết quả trả về từ terminal
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // In ra kết quả terminal
            }

            reader.close();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}