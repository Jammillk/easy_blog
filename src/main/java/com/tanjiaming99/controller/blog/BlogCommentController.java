package com.tanjiaming99.controller.blog;


import com.tanjiaming99.common.ajax.AjaxRes;
import com.tanjiaming99.common.model.Page;
import com.tanjiaming99.model.dto.CommentDTO;
import com.tanjiaming99.model.dto.CommentReplyDTO;
import com.tanjiaming99.model.dto.CommentStatusDTO;
import com.tanjiaming99.model.entity.BlogComment;
import com.tanjiaming99.service.IBlogCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:40
 */
@RestController
@RequestMapping("/blog-comment")
@Api(value = "评论管理模块", tags = "评论管理模块")
public class BlogCommentController {

    @Autowired
    private IBlogCommentService blogCommentService;

    @ApiOperation(value = "新增一条评论")
    @RequestMapping(method = RequestMethod.POST)
    public AjaxRes<?> create(@RequestBody @Valid CommentDTO dto) {
        return blogCommentService.createComment(dto) ? AjaxRes.success("新增评论成功") : AjaxRes.fail("新增评论失败");
    }

    @ApiOperation(value = "回复一条评论")
    @PostMapping("/reply")
    public AjaxRes<?> reply(@RequestBody @Valid CommentReplyDTO dto) {
        return blogCommentService.replyComment(dto) ? AjaxRes.success("回复评论成功") : AjaxRes.fail("回复评论失败");
    }

    @ApiOperation(value = "修改评论状态")
    @PostMapping("/censor")
    public AjaxRes<?> censor(@RequestBody @Valid CommentStatusDTO dto) {
        return blogCommentService.censorComment(dto) ? AjaxRes.success("修改评论状态成功") : AjaxRes.fail("修改评论状态失败");
    }

    @ApiOperation(value = "删除一条评论", notes = "只需传入commentId即可")
    @RequestMapping(method = RequestMethod.DELETE)
    public AjaxRes<?> remove(@RequestBody CommentDTO dto) {
        return blogCommentService.removeById(dto.getCommentId()) ? AjaxRes.success("删除评论成功") : AjaxRes.fail("删除评论失败");
    }

    @ApiOperation(value = "分页查询评论功能")
    @PostMapping("/page")
    public AjaxRes<Page<BlogComment>> page(@RequestBody Page<BlogComment> page) {
        return AjaxRes.success(blogCommentService.page(page));
    }


}
