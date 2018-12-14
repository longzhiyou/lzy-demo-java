package lzy.common;

import lombok.Data;

/**
 * rest服务返回json格式的响应对象.
 *  https://github.com/NationalBankBelgium/REST-API-Design-Guide/wiki/Error-handling-Example-with-multiple-errors
 *  "type": "https://api.demo.nbb.be/v1/errors/validation",
 *     "title": "Validation errors",
 *     "titleKey": "errors.validation",
 *     "errors": [
 *         {
 *             "type": "https://api.demo.nbb.be/v1/errors/validation-user-invalid",
 *             "title": "Invalid user information",
 *             "titleKey": "errors.validation.user.invalid",
 *             "detail": "The start date must be before the end date",
 *             "detailKey": "errors.validation.user.invalid.start.date.after.end.date",
 *             "fields": [
 *                 "start-date",
 *                 "end-date"
 *             ],
 *             "identifier": "9335d74d-2649-4eec-a272-ab2803e25a40"
 *         },
 *         {
 *             "type": "https://api.demo.nbb.be/v1/errors/validations-user-invalid",
 *             "title": "Invalid user information",
 *             "titleKey": "errors.validation.user.invalid",
 *             "detail": "The username is already in use",
 *             "detailKey": "errors.validation.user.invalid.username.already.in.use",
 *             "fields": [
 *                 "username"
 *             ],
 *             "identifier": "b9b41a65-28ed-4736-ab05-9d4defdcdd23"
 *         }
 *     ]
 * @since 1.0.0
 */
@Data
public class ResponseDetailMessage {

    String type;
    String title;
    String titleKey;
    String detail;
    String detailKey;
    String identifier;
    Object fields;

}
