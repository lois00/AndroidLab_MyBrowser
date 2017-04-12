package cl.fjnu.edu.cn.mybrowser;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Aty_MyBrowser extends AppCompatActivity {
        private WebView webView;
        private static final String URL_DEFAULT = "http://www.baidu.com";//浏览器的默认主页
        private Uri uri;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // 取消标题
            this.requestWindowFeature(Window.FEATURE_NO_TITLE);
            // 进行全屏
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.aty_my_browser);
            uri =getIntent().getData();//获取从前一个activity传递过来的uri数据
            if(uri == null){//如果是空uri，则打开默认主页
                uri = Uri.parse(URL_DEFAULT);
            }
            // 实例化WebView
            webView = (WebView) this.findViewById(R.id.webView);
            webView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                    view.loadUrl(uri.toString());//这句可写可不写
                    return true;
                }
            });
            // 调用loadUrl()方法进行加载内容
            webView.loadUrl(uri.toString());
            //获取webview的属性对象
            WebSettings webSettings =  webView.getSettings();
            // 设置WebView的属性，此时可以去执行JavaScript脚本
            webSettings.setJavaScriptEnabled(true);
            //设置屏幕缩放自适应
            webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            /**
             * 用WebView显示图片，可使用这个参数 设置网页布局类型：
             * 1、LayoutAlgorithm.NARROW_COLUMNS ：适应内容大小
             * 2、LayoutAlgorithm.SINGLE_COLUMN:适应屏幕，内容将自动缩放
             */
            webSettings.setUseWideViewPort(true);//设置此属性,可任意比例缩放
            webSettings.setBuiltInZoomControls(true); // 设置显示缩放按钮
            webSettings.setSupportZoom(true); // 支持缩放
        }
}


