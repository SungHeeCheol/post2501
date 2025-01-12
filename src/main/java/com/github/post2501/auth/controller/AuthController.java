package com.github.post2501.auth.controller;

import com.github.post2501.auth.dto.SignUpDto;
import com.github.post2501.auth.service.UserService;
import com.github.post2501.global.dto.MsgResponseDto;
import com.github.post2501.global.exception.ErrorCode;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    // 회원가입
    @Operation(summary = "유저 회원가입", description = "회원가입 api 입니다.")
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpDto signUpDto, BindingResult bindingResult) throws Exception{
      log.info("[POST]: 회원가입 요청");

      if (bindingResult.hasErrors()) {
          return ResponseEntity.badRequest().body(ErrorCode.BINDING_RESULT_ERROR.getMessage());
      }

      userService.signUp(signUpDto);

      return ResponseEntity.ok(new MsgResponseDto("회원가입이 완료되었습니다.", HttpStatus.OK.value()));
    }
}
