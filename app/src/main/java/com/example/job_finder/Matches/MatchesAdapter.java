package com.example.job_finder.Matches;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.job_finder.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesViewHolder> {

    private List<MatchesObject> matchesList;
    private Context context;

    public MatchesAdapter ( List <MatchesObject> matchesList , Context context ) {
        this.matchesList = matchesList;
        this.context = context;
    }

    @NonNull
    @Override
    public MatchesViewHolder onCreateViewHolder ( @NonNull ViewGroup parent , int viewType ) {
        View layoutView = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.item_matches, null, false );
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams ( ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT );
        layoutView.setLayoutParams ( lp );
        MatchesViewHolder rcv = new MatchesViewHolder ( layoutView );

        return rcv;
    }

    @Override
    public void onBindViewHolder ( @NonNull MatchesViewHolder holder , int position ) {

        holder.mMatchId.setText ( matchesList.get ( position ).getUserId () );
        holder.mBudget.setText ( matchesList.get ( position ).getBudget () );
        holder.mGive.setText ( matchesList.get ( position ).getGive () );
        holder.mProfile.setText ( matchesList.get ( position ).getProfileImageUrl () );
        holder.mNeed.setText ( matchesList.get ( position ).getNeed () );
        holder.mMatchName.setText ( matchesList.get ( position ).getName () );
        holder.mLastMessage.setText ( matchesList.get ( position ).getLastMessage () );
        String lastSeen="";
        lastSeen = matchesList.get ( position ).getLastSeen ();

        if(lastSeen.equals ( true )){
            holder.mNotificationDot.setVisibility ( View.VISIBLE );
        }else{
            holder.mNotificationDot.setVisibility ( View.INVISIBLE );
        }

        holder.mLastTimeStamp.setText ( matchesList.get ( position ).getLastTimeStamp () );
        if(!matchesList.get ( position ).getProfileImageUrl ().equals ( "default" )){
            Glide.with ( context ).load ( matchesList.get ( position ).getProfileImageUrl () ).into ( holder.mMatchImage );
        }
    }

    @Override
    public int getItemCount () {
        return 0;
    }
}
