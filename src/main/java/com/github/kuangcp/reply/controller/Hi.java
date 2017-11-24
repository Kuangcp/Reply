package com.github.kuangcp.reply.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by https://github.com/kuangcp on 17-8-28  上午11:41
 * 测试Springboot跑起来
 */
@RestController
public class Hi {

    @RequestMapping("/hi")
    public String hi(){
        return "Springboot 1.5.6";
    }

//    @GetMapping("/wx")
//    public String check(String signature, String timestamp, String nonce, String echostr){
//        System.out.println("校验");
//        if(sort(signature, timestamp, nonce)){
//            return echostr;
//        }
//        return null;
//    }
//    private boolean sort(String signature, String timestamp, String nonce){
//        final String token = "kuangcp";
//        // 排序
//        String [] arrs = new String[]{token, timestamp, nonce};
//        Arrays.sort(arrs);
//
//        // 生成随机字符串
//        StringBuilder temp = new StringBuilder();
//        for(int i=0; i<arrs.length; i++){
//            temp.append(arrs[i]);
//        }
//
//        // sha加密
//        String result = getSha1(temp.toString());
//
//        return result.equals(signature);
//    }
//
//    /**
//     * sha1 加密算法
//     * @param origin
//     * @return
//     */
//    private String getSha1(String origin){
//        char hex[] = {'0','1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
//
//        try{
//            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
//            messageDigest.update(origin.getBytes("UTF-8"));
//            byte[] md = messageDigest.digest();
//            int j = md.length;
//            char []buff = new char[j*2];
//            int k = 0;
//            for(int i=0;i<j; i++){
//                byte byte0 = md[i];
//                buff[k++] = hex[byte0 >>> 4 & 0xf];
//                buff[k++] = hex[byte0 & 0xf];
//            }
//            return new String(buff);
//        }catch (Exception e){
//            return null;
//        }
//    }
//    // 对象里面如果和参数列表中某参数同名会报错，所以要 避免 /wx/user
//    @PostMapping("/wx")
//    public String reviceMess(HttpServletRequest request) {
//        System.out.println("dfsdfsdfsd");
//        TextMsg text = new TextMsg();
//        Map<String, String> params = null;
//        try {
//            params = xmlToMap(request);
//            text.setMsgType(params.get("MsgType"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if ("text".equals(text.getMsgType())) {
//            System.out.println(text.toString());
//        }
//        text.setToUserName(params.get("FromUserName"));
//        text.setFromUserName(params.get("ToUserName"));
////        text.setMsgType("text");
//        text.setContent("你发送的消息是: " + params.get("Content"));
//        text.setCreateTime(new Date().getTime() + "");
//        return texttoXml(text);
//    }
//
//    /**
//     * request请求中XML转换为map
//     * @param request
//     * @return
//     * @throws IOException
//     * @throws DocumentException
//     */
//    private Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {
//        InputStream ins = request.getInputStream();
//        Map<String, String> map = new HashMap<>();
//        SAXReader reader = new SAXReader();
//        Document doc = reader.read(ins);
//        Element root = doc.getRootElement();
//        List<Element> list = root.elements();
//        for (Element temp:list){
//            map.put(temp.getName(), temp.getText());
//        }
//        ins.close();
//
//        return map;
//    }
//
//    private String texttoXml(TextMsg text){
//        XStream xstream = new XStream();
//        xstream.alias("xml", text.getClass());
//        String result = xstream.toXML(text);
//        System.out.println(result);
//        return result;
//    }
}
