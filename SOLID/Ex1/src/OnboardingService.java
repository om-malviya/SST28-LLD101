import java.util.List;

public class OnboardingService {
    private final StudentStore store;
    private final OnboardingPrinter printer;
    private final RawInputParser parser;
    private final StudentValidator validator;

    public OnboardingService(StudentStore store, OnboardingPrinter printer,
                             RawInputParser parser, StudentValidator validator) {
        this.store = store;
        this.printer = printer;
        this.parser = parser;
        this.validator = validator;
    }

    public void registerFromRawInput(String raw) {
        printer.printInput(raw);

        ParsedInput parsed = parser.parse(raw);
        List<String> errors = validator.validate(parsed);
        if (!errors.isEmpty()) {
            printer.printValidationErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(store.count());
        StudentRecord rec = new StudentRecord(id, parsed.name, parsed.email, parsed.phone, parsed.program);
        store.save(rec);
        printer.printConfirmation(rec, store.count());
    }
}
