/*
 * jQuery validation 验证类型扩展
 *
 * 扩展的验证类型：用户名，邮政编码，大陆身份证号码，大陆手机号码,电话号码,姓
 * 
 * 2010-06-17 by 刘仁飞
 * 2014-01-21 16:38:21 modified by Jelon
 */
// 邮政编码验证    
jQuery.validator.addMethod("isZipCode", function(value, element) {
    var zip = /^[0-9]{6}$/;
    return this.optional(element) || (zip.test(value));
}, "请正确填写您的邮政编码!");
// 身份证号码验证
jQuery.validator.addMethod("isIdCardNo", function(value, element) {
    var idCard = /^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\w)$/;
    return this.optional(element) || (idCard.test(value));
}, "请输入正确的身份证号码!");

// 手机号码验证    
jQuery.validator.addMethod("isMobile", function(value, element) {
    var length = value.length;
    return this.optional(element) || (length == 11 && /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/.test(value));
}, "请正确填写您的手机号码!");

// 电话号码验证    
jQuery.validator.addMethod("isPhone", function(value, element) {
    var tel = /^(\d{3,4}-?)?\d{7,9}$/g;
    return this.optional(element) || (tel.test(value));
}, "请正确填写您的电话号码!")

// 用户名字符验证    
jQuery.validator.addMethod("userName", function(value, element) {
    return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value);
}, "用户名只能包括中文字、英文字母、数字和下划线!");

// 联系电话(手机/电话皆可)验证   
jQuery.validator.addMethod("isTel", function(value, element) {
    var length = value.length;
    var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;
    var tel = /^\d{3,4}-?\d{7,9}$/;
    return this.optional(element) || (tel.test(value) || mobile.test(value));
}, "请正确填写您的联系电话!");

// IP地址验证   
jQuery.validator.addMethod("ip", function(value, element) {
    return this.optional(element) || /^(([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))\.)(([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))\.){2}([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))$/.test(value);
}, "请填写正确的IP地址！");
// 百家姓验证
jQuery.validator.addMethod("isSurname", function(value, element) {
    return this.optional(element) || /^(赵|钱|孙|李|周|吴|郑|王|冯|陈|楮|卫|蒋|沈|韩|杨|朱|秦|尤|许|何|吕|施|张|孔|曹|严|华|金|魏|陶|姜|戚|谢|邹|喻|柏|水|窦|章|云|苏|潘|葛|奚|范|彭|郎|鲁|韦|昌|马|苗|凤|花|方|俞|任|袁|柳|酆|鲍|史|唐|费|廉|岑|薛|雷|贺|倪|汤|滕|殷|罗|毕|郝|邬|安|常|乐|于|时|傅|皮|卞|齐|康|伍|余|元|卜|顾|孟|平|黄|和|穆|萧|尹|姚|邵|湛|汪|祁|毛|禹|狄|米|贝|明|臧|计|伏|成|戴|谈|宋|茅|庞|熊|纪|舒|屈|项|祝|董|梁|杜|阮|蓝|闽|席|季|麻|强|贾|路|娄|危|江|童|颜|郭|梅|盛|林|刁|锺|徐|丘|骆|高|夏|蔡|田|樊|胡|凌|霍|虞|万|支|柯|昝|管|卢|莫|经|房|裘|缪|干|解|应|宗|丁|宣|贲|邓|郁|单|杭|洪|包|诸|左|石|崔|吉|钮|龚|程|嵇|邢|滑|裴|陆|荣|翁|荀|羊|於|惠|甄|麹|家|封|芮|羿|储|靳|汲|邴|糜|松|井|段|富|巫|乌|焦|巴|弓|牧|隗|山|谷|车|侯|宓|蓬|全|郗|班|仰|秋|仲|伊|宫|宁|仇|栾|暴|甘|斜|厉|戎|祖|武|符|刘|景|詹|束|龙|叶|幸|司|韶|郜|黎|蓟|薄|印|宿|白|怀|蒲|邰|从|鄂|索|咸|籍|赖|卓|蔺|屠|蒙|池|乔|阴|郁|胥|能|苍|双|闻|莘|党|翟|谭|贡|劳|逄|姬|申|扶|堵|冉|宰|郦|雍|郤|璩|桑|桂|濮|牛|寿|通|边|扈|燕|冀|郏|浦|尚|农|温|别|庄|晏|柴|瞿|阎|充|慕|连|茹|习|宦|艾|鱼|容|向|古|易|慎|戈|廖|庾|终|暨|居|衡|步|都|耿|满|弘|匡|国|文|寇|广|禄|阙|东|欧|殳|沃|利|蔚|越|夔|隆|师|巩|厍|聂|晁|勾|敖|融|冷|訾|辛|阚|那|简|饶|空|曾|毋|沙|乜|养|鞠|须|丰|巢|关|蒯|相|查|后|荆|红|游|竺|权|逑|盖|益|桓|公|万俟|司马|上官|欧阳|夏侯|诸葛|闻人|东方|赫连|皇甫|尉迟|公羊|澹台|公冶|宗政|濮阳|淳于|单于|太叔|申屠|公孙|仲孙|轩辕|令狐|锺离|宇文|长孙|慕容|鲜于|闾丘|司徒|司空|丌官|司寇|仉|督|子车|颛孙|端木|巫马|公西|漆雕|乐正|壤驷|公良|拓拔|夹谷|宰父|谷梁|晋|楚|阎|法|汝|鄢|涂|钦|段干|百里|东郭|南门|呼延|归|海|羊舌|微生|岳|帅|缑|亢|况|后|有|琴|梁丘|左丘|东门|西门|商|牟|佘|佴|伯|赏|南宫|墨|哈|谯|笪|年|爱|阳|佟|第五|言|福)/.test(value);
}, "请填写正确的姓氏");
//扩展的邮箱验证 支持多级域名的邮箱
jQuery.validator.addMethod("myemail", function(value, element) {
    return this.optional(element) || /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/.test(value);
}, "请填写正确的姓氏");


//身份证号码的验证规则

function isIdCardNo(num) {　 //　 if (isNaN(num)) {alert("输入的不是数字！"); return false;} 
    　　
    var len = num.length,
        re;　　
    if (len == 15)　　re = new RegExp(/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{2})(\w)$/);　　
    else if (len == 18)　　re = new RegExp(/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\w)$/);　　
    else {
        alert("输入的数字位数不对！");
        return false;
    }　　
    var a = num.match(re);　　
    if (a != null)　　 {　　
        if (len == 15)　　 {　　
            var D = new Date("19" + a[3] + "/" + a[4] + "/" + a[5]);　　
            var B = D.getYear() == a[3] && (D.getMonth() + 1) == a[4] && D.getDate() == a[5];　　
        }　　
        else　　 {　　
            var D = new Date(a[3] + "/" + a[4] + "/" + a[5]);　　
            var B = D.getFullYear() == a[3] && (D.getMonth() + 1) == a[4] && D.getDate() == a[5];　　
        }　　
        if (!B) {
            alert("输入的身份证号 " + a[0] + " 里出生日期不对！");
            return false;
        }　　
    }　　
    if (!re.test(num)) {
        alert("身份证最后一位只能是数字和字母!");
        return false;
    }　　　　
    return true;
}