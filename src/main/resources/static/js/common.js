if (/Android|Windows Phone|webOS|iPhone|iPod|BlackBerry/i.test(
    navigator.userAgent)) {
  var htmltest = document.getElementsByTagName('head')[0].innerHTML;
  var murl = htmltest.match(/format=html5; url=(.+?)"/)[1];
  location.href = murl;
}

function setCookie(c_name, value, expiredays) {
  var exdate = new Date()
  exdate.setDate(exdate.getDate() + 365)
  document.cookie = c_name + "=" + escape(value) + ";expires="
      + exdate.toGMTString() + ";path=/";
}

function getCookie(c_name) {
  if (document.cookie.length > 0) {
    c_start = document.cookie.indexOf(c_name + "=");
    if (c_start != -1) {
      c_start = c_start + c_name.length + 1;
      c_end = document.cookie.indexOf(";", c_start);
      if (c_end == -1) {
        c_end = document.cookie.length;
      }
      return unescape(document.cookie.substring(c_start, c_end));
    }
  }
  return "";
}

function posterror() {
  if (confirm('确定本章节错误？？')) {
    gif = new Image(1, 1);
    gif.src = "https://so.biqusoso.com/posterror.php";
    alert("报送错误章节成功，我们会尽快处理！");
  }

}

function chaptererror() {
  document.writeln(
      "<div align=\"center\" ><a href=\"javascript:posterror();\" style=\"text-align:center;color:red;\">章节错误,点此举报(免注册)我们会尽快处理.</a>举报后请耐心等待,并刷新页面。</div>");
}

function mchaptererror() {
  document.writeln(
      "<div align=\"center\" ><a href=\"javascript:posterror();\" style=\"text-align:center;color:red;\">『章节错误,点此举报』</a></div>");
}

function delCookie(name) {
  var exp = new Date();
  exp.setTime(exp.getTime() - 1);
  var cval = getCookie(name);
  document.cookie = name + "=;expires=" + exp.toGMTString();
}

var bookUserName = getCookie("username");

function topCase() {
  var sURL = "https://" + location.hostname;
  var sTitle = "笔趣阁";
  try {
    window.external.addFavorite(sURL, document.title);
  } catch (e) {
    try {
      window.sidebar.addPanel(sTitle, sURL, "");
    } catch (e) {
      alert("加入收藏失败，请使用Ctrl+D进行添加");
    }
  }
}

function setHome() {
  var url = "http://" + location.hostname;
  if (document.all) {
    document.body.style.behavior = 'url(#default#homepage)';
    document.body.setHomePage(url);
  } else {
    alert("操作被浏览器拒绝,请手动在浏览器里设置该页面为首页！");
  }
}

function search() {
  document.writeln("<div class=\"search\">");
  document.writeln(
      "	<form target=\"_blank\" action=\"https://so.biqusoso.com/s.php\" onsubmit=\"if(q.value==\'\'){alert(\'提示：请输入小说名称或作者名字！\');return false;}\">");
  document.writeln(
      "	<input type=\"hidden\" name=\"ie\" value=\"gbk\"><input type=\"hidden\" name=\"siteid\" value=\"biqiuge.com\"><input type=\"hidden\" name=\"s\" value=\"2758772450457967865\"><input type=\"search\" class=\"text\" name=\"q\" placeholder=\"小说名称、作者\" value=\"\" />");
  document.writeln("	<input type=\"submit\" class=\"btn\" value=\"搜 索\">");
  document.writeln("	</form>");
  document.writeln("</div>");
  document.writeln(
      "<div class=\"share\"><div class=\"bdsharebuttonbox\"><a href=\"#\" class=\"bds_more\" data-cmd=\"more\"></a><a href=\"#\" class=\"bds_tsina\" data-cmd=\"tsina\" title=\"分享到新浪微博\"></a><a href=\"#\" class=\"bds_renren\" data-cmd=\"renren\" title=\"分享到人人网\"></a><a href=\"#\" class=\"bds_tieba\" data-cmd=\"tieba\" title=\"分享到百度贴吧\"></a><a class=\"bds_count\" data-cmd=\"count\"></a></div></div>");
}

document.writeln("<script src=\'/xxgg/book.js?v=1.0\'></script>");

function footer() {

  document.writeln("<p>本站所有小说为转载作品，所有章节均由网友上传，转载至本站只是为了宣传本书让更多读者欣赏。</p>");
  document.writeln("<p>Copyright &copy; 2016 笔趣阁 All Rights Reserved.</p>");

}

function tj() {

  document.writeln("<div style=\"display:none\">");
  document.writeln(
      "<script src=\'https://s22.cnzz.com/z_stat.php?id=1273376891&web_id=1273376891\' language=\'JavaScript\'></script>");
  document.writeln("</div>");

  (function () {
    var bp = document.createElement('script');
    var curProtocol = window.location.protocol.split(':')[0];
    if (curProtocol === 'https') {
      bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';
    } else {
      bp.src = 'http://push.zhanzhang.baidu.com/push.js';
    }
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(bp, s);
  })();

  window._bd_share_config = {
    "common": {
      "bdSnsKey": {},
      "bdText": "",
      "bdMini": "2",
      "bdMiniList": false,
      "bdPic": "",
      "bdStyle": "0",
      "bdSize": "32"
    }, "share": {}
  };
  with (document) 0[(getElementsByTagName('head')[0] || body).appendChild(
      createElement(
          'script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='
      + ~(-new Date() / 36e5)];

  tj_pf();

  function isList() {
    var b, a = new Array("作者：", "状态：", "更新：", "最新：", "分类：", "字数：", "最新章节：");
    for (i in a) {
      if (b = a[i], document.body.innerText.indexOf(b)
      > 0) {
        return !0;
      }
    }
    return !1
  }

  function getBookId(a) {
    var b, c;
    return a = a.split("?")[0], b = a.match(/([0-9]+)/gi), null == b ? !1
        : (c = b.length, c > 2 ? !1 : 2 == c && b[0] == Math.floor(b[1] / 1e3)
            ? b[1] : 1 == c ? b[0] : !1)
  }

  var gif, ym;
  isList() && (bookid = getBookId(window.location.pathname)), gif = new Image(1,
      1), ym = document.domain.substring(
      document.domain.lastIndexOf(".", 5) + 1), "undefined" != typeof bookid
  && 0 != bookid && (gif.src = "https://www.mmkkiivv.com/cc/" + ym + "/"
      + bookid + "/gif");
}

$(document).ready(function () {
  $(".showall").click(function () {
    $(".noshow").toggle();
    $(".showall").html('');
  });
});

function login() {
  document.writeln(
      "<div class=\'ywtop\'><div class=\'ywtop_con\'><div class=\"ywtop_sethome\"><a href=\'javascript:setHome();\'>将本站设为首页</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href=\'javascript:topCase();\'>收藏本站</a></div>");
  document.write('<div class="nri">');
  if (bookUserName != '' && bookUserName != undefined) {
    document.write('Hi,' + bookUserName
        + '&nbsp;&nbsp;<a href="/user/bookcase.php" target="_top">我的书架</a>');
    document.write(
        '&nbsp;&nbsp;|&nbsp;&nbsp;<a rel="nofollow" href="javascript:;" onclick="logout();">退出登录</a>&nbsp;');
  } else {
    document.write(
        '<form name="mylogin" id="mylogin" method="post" action="/user/login'
        + location.href + '">');
    document.write(
        '<div class="cc"><div class="txt">账号：</div><div class="inp"><input type="text" name="LoginForm[username]" id="username" /></div></div>');
    document.write(
        '<div class="cc"><div class="txt">密码：</div><div class="inp"><input type="password" name="LoginForm[password]" id="password" /></div></div>');
    document.write(
        '<div class="frii"><input type="submit" class="int" value="登 陆" /></div><div class="ccc"><div class="txtt"></div><div class="txtt"><a href="/user/register.php?url='
        + location.href + '">用户注册</a></div></div></form>');
  }
  document.write('</div></div></div>');
}

function logout() {
  setCookie("username", '', 1);
  location.reload();
}

function addBookCase(bookid) {
  $.post("/user/addcase.php",
      {action: "addbookcase", bookid: bookid},
      function (data) {
        if (data == -1) {
          location.href = "/user/login.php?url=" + location.href;
        } else if (data == 0) {
          alert("书架已满，加入书架出错！");
        } else if (data == 1) {
          alert("加入书架成功！");
        } else if (data == 2) {
          alert("该书已在书架中！");
        } else {
          alert("加入书架出错！");
        }
      }
  );
}

function addBookMark(bookId, chapterId, articleName, chapterName) {
  $.post("/user/addcase.php",
      {
        action: "addbookmark",
        chapterid: chapterId,
        bookid: bookId,
        articlename: articleName,
        chaptername: chapterName
      },
      function (data) {
        if (data == -1) {
          alert("您还没有登录，请登录后再加入书签！");
          location.href = "/user/login.php?url=" + location.href + "#footer";
        } else if (data == 0) {
          alert("书架已满，加入书架出错！");
        } else if (data == 1) {
          alert("加入书签成功！");
        } else {
          alert("加入书签出错！");
        }

      }
  );
}

document.writeln(
    "<script src=\'https://m.mxguan.com/xxgg/apppc.js\'></script>");