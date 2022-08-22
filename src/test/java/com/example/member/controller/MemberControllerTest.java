package com.example.member.controller;

import com.example.member.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest       // (1)
@AutoConfigureMockMvc
@AutoConfigureRestDocs// (2)
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void postMemberTest() throws Exception {
        // given
         Member member =new Member();
        // when

        int page = 1;
        int size = 10;
        Long sectorCode = 3L;
        Long regionCode = 3L;
        ResultActions actions = mockMvc.perform(
                get("/api/v1")
                        .param("page", String.valueOf(page))K
                        .param("size", String.valueOf(size))
                        .param("type", String.valueOf(sectorCode))
                        .param("location", String.valueOf(regionCode))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        );
        // then
       actions
                .andExpect(status().isOk()) // (8)
                .andDo(
                        document(
                               "get-members",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                requestParameters(
                                        parameterWithName("page").description("페이지 위치").optional(),
                                        parameterWithName("size").description("페이지 개수").optional(),
                                        parameterWithName("type").description("업종 번호").optional(),
                                        parameterWithName("location").description("지역 번호").optional()
                                ),
                                responseFields(
                                        List.of(
                                                fieldWithPath("data").description("데이터"),
                                                fieldWithPath("pageInfo").description("페이징 정보")
                                        )
                                ).andWithPrefix("data[].",
                                        List.of(
                                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("아이디"),
                                                fieldWithPath("name").type(JsonFieldType.STRING).description("이름"),
                                                fieldWithPath("password").type(JsonFieldType.STRING).description("비밀번호"),
                                                fieldWithPath("gender").type(JsonFieldType.STRING).description("성별"),
                                                fieldWithPath("companyName").type(JsonFieldType.STRING).description("회사이름"),
                                                fieldWithPath("locations.region").type(JsonFieldType.STRING).description("회사 지역"),
                                                fieldWithPath("types.categories").type(JsonFieldType.STRING).description("회사 업종")
                                        )
                                ).andWithPrefix("pageInfo.",
                                        List.of(
                                                fieldWithPath("page").type(JsonFieldType.NUMBER).description("현재 페이지"),
                                                fieldWithPath("size").type(JsonFieldType.NUMBER).description("페이지 당 표현할 데이터 개수"),
                                                fieldWithPath("totalElements").type(JsonFieldType.NUMBER).description("데이터 총 개수"),
                                                fieldWithPath("totalPages").type(JsonFieldType.NUMBER).description("페이지 총 개수")
                                        )
                                )
                        )
                );

                // (9)

        //System.out.println(result.getResponse().getContentAsString());
    }
}