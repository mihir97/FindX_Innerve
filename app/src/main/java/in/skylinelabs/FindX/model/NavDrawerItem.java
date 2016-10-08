package in.skylinelabs.FindX.model;


public class NavDrawerItem {
    private boolean showNotify;
    private String title;
    private int mIcons;
    public NavDrawerItem() {

    }

    public NavDrawerItem(boolean showNotify, String title, int mIcons) {
        this.showNotify = showNotify;
        this.title = title;
        this.mIcons = mIcons;
    }

    public boolean isShowNotify() {
        return showNotify;
    }

    public void setShowNotify(boolean showNotify) {
        this.showNotify = showNotify;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return mIcons;
    }

    public void setIcon(int mIcons) {
        this.mIcons = mIcons;
    }
}
