public class ParsedInput {
    public final String name;
    public final String email;
    public final String phone;
    public final String program;

    public ParsedInput(String name, String email, String phone, String program) {
        this.name = name != null ? name : "";
        this.email = email != null ? email : "";
        this.phone = phone != null ? phone : "";
        this.program = program != null ? program : "";
    }
}
