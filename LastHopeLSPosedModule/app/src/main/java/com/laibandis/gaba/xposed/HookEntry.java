package com.laibandis.gaba.xposed;

import com.laibandis.gaba.PhotoStore;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import de.robv.android.xposed.XposedBridge;

public class HookEntry implements IXposedHookLoadPackage {
    private static final String TAG = "LSPosed-Hook";

    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        XposedBridge.log(TAG + " loading for: " + lpparam.packageName);

        if ("com.maco.lasthope".equals(lpparam.packageName)) {
            XposedBridge.log(TAG + " hooking target app: " + lpparam.packageName);

            byte[] photo = PhotoStore.getPhotoBytes();
            if (photo != null) {
                XposedBridge.log(TAG + " found stored photo bytes length=" + photo.length);
            } else {
                XposedBridge.log(TAG + " no stored photo");
            }

            // TODO: добавить конкретные хуки для методов сохранения/отправки фото
        }
    }
}
