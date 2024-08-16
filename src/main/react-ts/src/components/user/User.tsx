import React from 'react';
import { UserProps } from '../../props/UserProps';
import './user.css';
import DEFAULT_BANNER from '../../assets/default_banner.png';
import DEFAULT_PFP from '../../assets/default-user-pfp.png';
import RATING from '../../assets/rating.svg';
import CAKE from '../../assets/cake.svg';

export class User extends React.Component {
    userProps: UserProps;

    constructor(userProps: UserProps, props: any) {
        super(props);
        this.userProps = userProps;
    }

    render() {
        return (
            <div className='user'>
                <img className="user-banner" src={this.userProps.banner === null ? DEFAULT_BANNER : this.userProps.banner} alt='banner' />
                <div className='user-header'>
                    <img src={this.userProps.pfp === null ? DEFAULT_PFP : this.userProps.pfp} alt='pfp' />
                    <h2>{'u/' + this.userProps.name}</h2>
                </div>
                <div className='user-info'>
                    <div className='user-info-sub' data-title='Рейтинг'>
                        <img src={RATING} alt='rating'/>
                        {' ' + this.userProps.rating}
                    </div>
                    <div className='user-info-sub' data-title='Дата'>
                        <img src={CAKE} alt='cakedate'></img>
                        {' ' + this.userProps.cakedate}
                    </div>
                    <div className='user-description'>{this.userProps.description}</div>
                </div>
            </div>
        );
    }
}

export const UserPrev = (user: UserProps) => {
    return (
        <div className='user-prev'>
            <img src={user.pfp === null ? require('../../assets/default_banner.png') : user.pfp} alt='pfp' />
            <h2>{'u/' + user.name}</h2>
        </div>
    );
}