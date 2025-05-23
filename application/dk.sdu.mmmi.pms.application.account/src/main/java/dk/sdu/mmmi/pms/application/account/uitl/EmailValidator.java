package dk.sdu.mmmi.pms.application.account.uitl;

import dk.sdu.mmmi.pms.application.account.AccountRepository;
import dk.sdu.mmmi.pms.core.account.exception.EmailDuplicateException;
import dk.sdu.mmmi.pms.core.account.exception.EmailFormatException;

public class EmailValidator {
    /**
     * Validates the email format.
     *
     * @param email the email address to validate
     * @throws EmailFormatException if the email format is invalid
     */
    public static void validateFormat(String email) throws EmailFormatException {
        // Check if the email exceeds length (320 characters)
        if (email.length() > 320) {
            throw new EmailFormatException("Email is too long: " + email);
        }

        // Check if email matches the regex
        String emailRegex = "^[a-zA-Z0-9._%+-]{2,}@"
                + "(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+"
                + "[a-zA-Z]{2,}$";
        if (!email.matches(emailRegex)) {
            throw new EmailFormatException("Invalid email format: " + email);
        }
    }

    /**
     * Validates that the email is unique.
     *
     * @param email the email address to validate
     * @throws EmailDuplicateException if the email already exists
     */
    public static void validateUniqueness(String email, AccountRepository accountRepository) throws EmailDuplicateException {
        if (accountRepository.findByEmail(email).isPresent()) {
            throw new EmailDuplicateException("An account with the email " + email + " already exists.");
        }
    }
}