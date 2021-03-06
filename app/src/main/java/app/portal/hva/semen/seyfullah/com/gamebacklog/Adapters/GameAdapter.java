package app.portal.hva.semen.seyfullah.com.gamebacklog.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

import app.portal.hva.semen.seyfullah.com.gamebacklog.Classes.Games;
import app.portal.hva.semen.seyfullah.com.gamebacklog.R;

/*
 * Created by Seyfullah Semen on 29-9-2018.
 */
public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {
    private List<Games> mGames;
    private Context mContext;
    final private ReminderClickListener mReminderClickListener;

    public GameAdapter(Context mContext, List<Games> mGames, ReminderClickListener mReminderClickListener) {
        this.mGames = mGames;
        this.mContext = mContext;
        this.mReminderClickListener = mReminderClickListener;
    }

    public interface ReminderClickListener {
        void reminderOnClick(int i);
    }

    @NonNull
    @Override
    public GameAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.backlog_card, parent, false);
        return new GameAdapter.ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull GameAdapter.ViewHolder holder, int position) {
        Calendar calander = Calendar.getInstance();
        int cDay = calander.get(Calendar.DAY_OF_MONTH);
        int cMonth = calander.get(Calendar.MONTH) + 1;
        int cYear = calander.get(Calendar.YEAR);
        Games games = mGames.get(position);
        holder.mGameName.setText(games.mGameTitle);
        holder.mConsoleName.setText(games.mPlatformTitle);
        holder.mGameStatus.setText(games.mStatus);
        holder.mDate.setText(cDay + "/ " + cMonth + "/ " + cYear);

    }

    @Override
    public int getItemCount() {
        return mGames.size();
    }

    public void swapList(List<Games> newList) {
        mGames = newList;
        if (newList != null) {
            this.notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mGameName;
        public TextView mConsoleName;
        public TextView mGameStatus;
        public TextView mDate;

        public ViewHolder(View itemView) {
            super(itemView);
            mGameName = itemView.findViewById(R.id.game_name);
            mConsoleName = itemView.findViewById(R.id.console_type);
            mGameStatus = itemView.findViewById(R.id.game_status);
            mDate = itemView.findViewById(R.id.date);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mReminderClickListener.reminderOnClick(clickedPosition);
        }
    }
}
