package app.portal.hva.semen.seyfullah.com.gamebacklog.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import app.portal.hva.semen.seyfullah.com.gamebacklog.R;

/*
 * Created by Seyfullah Semen on 29-9-2018.
 */
public class Viewholder extends RecyclerView.ViewHolder {

    public TextView mGameName;
    public TextView mConsoleName;
    public TextView mGameStatus;

    public Viewholder(View itemView) {
        super(itemView);
        mGameName = itemView.findViewById(R.id.game_name);
        mConsoleName = itemView.findViewById(R.id.console_type);
        mGameStatus = itemView.findViewById(R.id.game_status);
    }
}
