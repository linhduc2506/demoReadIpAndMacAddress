package org.example;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        try {
            // Lấy địa chỉ IP của máy
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("Địa chỉ IP: " + ip.getHostAddress());

            // Lấy giao diện mạng dựa trên IP
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);

            // Lấy địa chỉ MAC
            byte[] mac = network.getHardwareAddress();

            if (mac != null) {
                System.out.print("Địa chỉ MAC: ");
                StringBuilder macAddress = new StringBuilder();
                for (int i = 0; i < mac.length; i++) {
                    macAddress.append(String.format("%02X", mac[i]));
                    if (i < mac.length - 1) {
                        macAddress.append("-");
                    }
                }
                System.out.println(macAddress.toString());
            } else {
                System.out.println("Không thể lấy địa chỉ MAC.");
            }

        }
        } catch (Exception e) {
            System.err.println("loi con me no roi");
        }
    }
}