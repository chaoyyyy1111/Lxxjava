public class EnumDemo {
    enum 性别 {
    男,女,神秘人;
}

    public static void main(String[] args) {
        性别 sex1 = 性别.女;
        性别 sex2 = 性别.男;
        性别[] values = 性别.values();
        for (性别 s:values) {
            System.out.println(s);
        }
    }


}
