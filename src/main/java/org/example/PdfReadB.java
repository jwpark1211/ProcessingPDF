package org.example;

import java.util.ArrayList;

public class PdfReadB implements PdfRead{

    @Override
    public String readPDF(String filePath) throws Exception {
        String date = filePath.replaceAll("[^0-9]","");
        String[] arr = new PdfReadUtil().readPDF(filePath).split("\n");
        String res = date+"\n";

        //3과목 ~ 4과목 사이 문자열 추출
        String range = "";
        for(int i=0; i<arr.length; i++) {
            if (arr[i].startsWith("최강") || arr[i].startsWith("건축") || arr[i].startsWith("3과목")) {
                continue;
            }
            if (arr[i].startsWith("41")) {
                range += arr[i];
                while (!arr[i + 1].startsWith("61")) {
                    if (arr[i + 1].matches("\\d.*")) {
                        range += "#";
                    }
                    range += arr[i + 1];
                    i++;
                }
            }
        }
        String questions[] = range.split("#");

        //정답 찾고 정리하기
        for(int i=0; i<questions.length; i++){
            char q[] = questions[i].toCharArray();
            int answer = 0;
            for(int j=0; j<q.length; j++){
                if(q[j]=='①'){ q[j-1] = '\n'; }
                else if(q[j]=='②'){ q[j-1] = '\n'; }
                else if(q[j]=='③'){ q[j-1] = '\n'; }
                else if(q[j]=='④'){ q[j-1] = '\n'; }

                if(q[j]=='❶') {
                    q[j - 1] = '\n';
                    q[j] = '①';
                    answer = 1;
                }else if(q[j]=='❷') {
                    q[j - 1] = '\n';
                    q[j] = '②';
                    answer = 2;
                }else if(q[j]=='❸') {
                    q[j - 1] = '\n';
                    q[j] = '③';
                    answer = 3;
                }else if(q[j]=='❹') {
                    q[j - 1] = '\n';
                    q[j] = '④';
                    answer = 4;
                }
            }
            questions[i] = String.valueOf(q);
            questions[i]+= '\n'+"[정답] "+answer+"번\n"+"[해설]\n\n";
            res+= questions[i];
        }

        return res;
    }
}
