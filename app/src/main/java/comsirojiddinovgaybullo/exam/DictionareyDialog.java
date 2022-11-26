package comsirojiddinovgaybullo.exam;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DictionareyDialog extends AlertDialog {

    View view;

    private EditText EngilishDialog, UzbekDialog;

    private OnSaveButtonClick onSaveButtonClick;

    private Button saveBtn;


    protected DictionareyDialog(@NonNull Context context) {
        super(context);

        Window window = getWindow();

        window.getDecorView().setBackgroundColor(Color.TRANSPARENT);

        view = LayoutInflater.from(context).inflate(R.layout.dictionarey_doalog, null, false);

        setView(view);

        setup(context);

    }

    public void setOnSaveButtonClick(OnSaveButtonClick onSaveButtonClick) {
        this.onSaveButtonClick = onSaveButtonClick;
    }

    private void setup(Context context) {

        EngilishDialog = view.findViewById(R.id.engilish_dialog);
        UzbekDialog = view.findViewById(R.id.uzbek_dialog);

        saveBtn = view.findViewById(R.id.save_btn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String English = EngilishDialog.getText().toString();
                String Uzbek = UzbekDialog.getText().toString();

                if (onSaveButtonClick != null) {
                    onSaveButtonClick.onSaveClick(English, Uzbek);
                }

                dismiss();

            }

        });

    }

    public interface OnSaveButtonClick {
        void onSaveClick(String english, String uzbek);
    }


}
