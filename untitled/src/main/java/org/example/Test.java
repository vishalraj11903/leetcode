package com.vogella.jersey.first.client;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class Test {

    public static void main(String[] args) {
        // Make it a palindrome.
      /*  String input = "aaabbabbb";
        StringBuilder output = new StringBuilder();
        int[] alpha = new int[26];
        for (int i = 0; i < input.length(); ++i) {
            alpha[input.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; ++i) {
            if (alpha[i] % 2 == 1) {
                int count = alpha[i];
                while (count-- > 0) {
                    output.append((char) (i + 'a'));
                }
                alpha[i] = -1;
            }
        }

        for (int i = 0; i < 26; ++i) {
            if (alpha[i] != -1) {
                int count = alpha[i] / 2;
                String tmp = output.toString();
                while (count-- > 0) {
                    char c = (char) (i + 'a');
                    tmp = c + tmp + c;
                }
                output = new StringBuilder(tmp);
            }
        }

        System.out.println(output);*/

        System.out.println(1 ^ 1 ^ 1);
    }

}