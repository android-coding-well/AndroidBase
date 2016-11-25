package com.junmeng.base.adapter.binding;

/**
 * 此类实现databinding的自定义属性
 * 此类对放置位置没有任何要求
 * databinding默认会优先使用我们的自定义属性
 * 当在布局文件中包含databinding表达式时下列才会生效（即使用@{...}）
 */
public class CustomBindingAdapter {

   /* //当BindingAdapter里的参数满足条件时会执行以下方法
    @BindingAdapter({"imageUrl","placeholder"})
    public static void loadImage(ImageView imageView, String url, Drawable placeholder){
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(placeholder)
                .into(imageView);
    }
    @BindingAdapter({"imageUrl","placeholder"})
    public static void loadImage(ImageView imageView, String url, int placeholder){
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(placeholder)
                .into(imageView);
    }
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String url){
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }


    //将日期转为格式化字符串
    @BindingConversion
    public static String convertDate(Date date) {
        if(date!=null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(date);
        }
        return "";

    }

    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int color) {
        return new ColorDrawable(color);

    }*/



}
