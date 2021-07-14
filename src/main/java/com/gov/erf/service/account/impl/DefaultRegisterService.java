package com.gov.erf.service.account.impl;

import com.gov.erf.config.validator.EmailValidator;
import com.gov.erf.dto.http.account.AddUserRequestDto;
import com.gov.erf.models.account.Admin;
import com.gov.erf.models.account.Role;
import com.gov.erf.models.account.token.ConfirmToken;
import com.gov.erf.models.claims.Region;
import com.gov.erf.models.sms.SMSRequest;
import com.gov.erf.repository.account.AdminRepository;
import com.gov.erf.service.account.AccountService;
import com.gov.erf.service.account.RegisterService;
import com.gov.erf.service.account.email.EmailSender;
import com.gov.erf.service.account.role.RoleService;
import com.gov.erf.service.claim.RegionService;
import com.gov.erf.service.sms.SmsService;
import com.gov.erf.service.token.ConfirmationTokenService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Collection;

@Service
public class DefaultRegisterService implements RegisterService {

    private final EmailValidator emailValidator;
    private final AccountService accountService;
    private final RoleService roleService;
    private final RegionService regionService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailSender emailSender;
    private final AdminRepository adminRepository;
    private final SmsService service;

    public DefaultRegisterService(
            EmailValidator emailValidator,
            AccountService accountService,
            RoleService roleService,
            RegionService regionService,
            BCryptPasswordEncoder bCryptPasswordEncoder,
            ConfirmationTokenService confirmationTokenService,
            EmailSender emailSender,
            AdminRepository adminRepository,
            SmsService service
    ) {
        this.emailValidator = emailValidator;
        this.accountService = accountService;
        this.roleService = roleService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.confirmationTokenService = confirmationTokenService;
        this.emailSender = emailSender;
        this.adminRepository = adminRepository;
        this.service = service;
        this.regionService = regionService;
    }

    @Override
    public String register(AddUserRequestDto addUserRequestDto) {

        boolean isValidEmail = emailValidator.test(addUserRequestDto.getEmail());

        Role role = roleService.findRole(addUserRequestDto.getRole());

        Region region = regionService.findRegion(addUserRequestDto.getRegion());

        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }
        String message = "Your data Login: " + addUserRequestDto.getUsername() + " Password: " + addUserRequestDto.getPassword();
        SMSRequest smsRequest = new SMSRequest(addUserRequestDto.getPhoneNumber(), message);

        String token = accountService.signUp(
                new Admin(
                        addUserRequestDto.getName(),
                        addUserRequestDto.getSurname(),
                        addUserRequestDto.getPatronymic(),
                        addUserRequestDto.getUsername(),
                        addUserRequestDto.getEmail(),
                        addUserRequestDto.getPhoneNumber(),
                        addUserRequestDto.getPassword(),
                        Boolean.FALSE,
                        Boolean.TRUE,
                        role,
                        region
                )
        );
        service.sender(smsRequest);
        String link = "http://localhost:8088/api/v1/account/confirm?token=" + token;
        emailSender.send(
                addUserRequestDto.getEmail(),
                buildEmail(addUserRequestDto.getName(), link));
        return token;
    }

    @Override
    @Transactional
    public String confirmToken(String token) {
        ConfirmToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiredAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        accountService.enableAppUser(
                confirmationToken.getAdmin().getEmail());
        return "confirmed";
    }

    @Override
    public Collection<Admin> getAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin findById(Long id) {
        return adminRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteById(Long id) {
        adminRepository.deleteById(id);
    }

    private String buildEmail(String name, String link) {
        return "<div style=\"font-family:Helvetica,Arial,sans-serif;font-size:16px;margin:0;color:#0b0c0c\">\n" +
                "\n" +
                "<span style=\"display:none;font-size:1px;color:#fff;max-height:0\"></span>\n" +
                "\n" +
                "  <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;min-width:100%;width:100%!important\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"100%\" height=\"53\" bgcolor=\"#0b0c0c\">\n" +
                "        \n" +
                "        <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;max-width:580px\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n" +
                "          <tbody><tr>\n" +
                "            <td width=\"70\" bgcolor=\"#0b0c0c\" valign=\"middle\">\n" +
                "                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td style=\"padding-left:10px\">\n" +
                "                  \n" +
                "                    </td>\n" +
                "                    <td style=\"font-size:28px;line-height:1.315789474;Margin-top:4px;padding-left:10px\">\n" +
                "                      <span style=\"font-family:Helvetica,Arial,sans-serif;font-weight:700;color:#ffffff;text-decoration:none;vertical-align:top;display:inline-block\">Confirm your email</span>\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "              </a>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"10\" height=\"10\" valign=\"middle\"></td>\n" +
                "      <td>\n" +
                "        \n" +
                "                <table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td bgcolor=\"#1D70B8\" width=\"100%\" height=\"10\"></td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\" height=\"10\"></td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "\n" +
                "\n" +
                "\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "      <td style=\"font-family:Helvetica,Arial,sans-serif;font-size:19px;line-height:1.315789474;max-width:560px\">\n" +
                "        \n" +
                "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">Hi " + name + ",</p><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> Thank you for registering. Please click on the below link to activate your account: </p><blockquote style=\"Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px\"><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> <a href=\"" + link + "\">Activate Now</a> </p></blockquote>\n Link will expire in 15 minutes. <p>See you soon</p>" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "  </tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n" +
                "\n" +
                "</div></div>";
    }

}
