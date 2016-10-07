package com.zhi.www.viewpagertest;

import android.content.Context;
import android.support.v4.view.ActionProvider;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

public class PlusActionProvider extends ActionProvider {
	private Context context ;
	public PlusActionProvider(Context context) {
		super(context);
		this.context = context ;
	}

	@Override
	public View onCreateActionView() {
		return null;
	}
	
	@Override
	public void onPrepareSubMenu(SubMenu submenu) {
		submenu.clear();
		submenu.add("发起群聊")
				.setIcon(R.mipmap.action_group_chat)
				.setOnMenuItemClickListener(new OnMenuItemClickListener() {

					@Override
					public boolean onMenuItemClick(MenuItem arg0) {
						Toast.makeText(context, "您点了发起群聊", Toast.LENGTH_SHORT).show();
						return true;
					}
				});

		submenu.add("添加朋友")
				.setIcon(R.mipmap.action_add_contacts)
				.setOnMenuItemClickListener(new OnMenuItemClickListener() {

					@Override
					public boolean onMenuItemClick(MenuItem arg0) {
						Toast.makeText(context, "您点了添加朋友", Toast.LENGTH_SHORT).show();
						return true;
					}
				});

		submenu.add("扫一扫")
				.setIcon(R.mipmap.action_scan_qr_code)
				.setOnMenuItemClickListener(new OnMenuItemClickListener() {

					@Override
					public boolean onMenuItemClick(MenuItem arg0) {
						Toast.makeText(context, "您点了扫一扫", Toast.LENGTH_SHORT).show();
						return true;
					}
				});

		submenu.add("意见与反馈")
				.setIcon(R.mipmap.action_feedback)
				.setOnMenuItemClickListener(new OnMenuItemClickListener() {

					@Override
					public boolean onMenuItemClick(MenuItem arg0) {
						Toast.makeText(context, "您点了意见与反馈", Toast.LENGTH_SHORT).show();
						return true;
					}
				});

	}
	
	@Override
	public boolean hasSubMenu()
	{
		return true;
	}
	
}