/**
 * 时间戳转时间
 * @param  {[type]} obj [description]
 * @return {[type]}     [description]
 */
function longtimeToDate(obj) {
    var date = new Date(obj);
    Y = date.getFullYear();
    M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1);
    D = date.getDate() + ' ';
    return Y + '-' + M + '-' + D;
}