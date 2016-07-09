/**
 * 用来打印一些特殊的js对象
 * @param obj
 * @returns {*}
 */
function printObj(obj) {
    try {
        seen = [];
        json = JSON.stringify(obj, function (key, val) {
            if (typeof val == "object") {
                if (seen.indexOf(val) >= 0) return;
                seen.push(val)
            }
            return val;
        });
        return json;
    } catch (e) {
        return e;
    }
}
/**
 * 判断传入值是否是数值
 * @param value
 * @returns {*}
 */
function isInteger(value) {
    if (parseInt(value) == value) {
        return parseInt(value);
    } else {
        return undefined;
    }
}
/**
 *  ajax返回统一处理函数
 * @param json 返回的数据
 * @param handleFunction 返回无错误时处理函数
 */
function ajaxReturnHandle(json, handleFunction) {
    //出错时
    if (undefined != json.errorMsg && '' != $.trim(json.errorMsg)) {
        layer.alert(json.errorMsg, {icon: 2});
    } else {
        //正常返回
        handleFunction(json);
    }
}