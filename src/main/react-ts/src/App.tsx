import './App.css';
import { getUsers } from './api/UserService';
import UserProps from './props/UserProps';
import { User, UserPreview } from './components/user/User';
import { Community } from './components/community/Community';
import React from 'react';
import { getCommunities } from './api/CommunityService';
import CommunityProps from './props/CommunityProps';
import PostProps from './props/PostProps';
import { getPosts } from './api/PostService';
import { Post } from './components/post/Post';

const users: UserProps[] = await getUsers();
const communities: CommunityProps[] = await getCommunities();
const posts: PostProps[] = await getPosts();

function App() {
  console.log(users);
  console.log(communities);
  console.log(posts);

  return (
    <div>
      {users.map((user: UserProps) =>
        <div key={user.id}>
          <User userProps={user}></User>
        </div>
      )
      }
      {communities.map((community: CommunityProps) =>
        <div key={community.id}>
          <Community props={community}></Community>
        </div>
      )
      }
      {posts.map((post: PostProps) => 
        <div key={post.id}>
          <Post props={post}></Post>
        </div>
      )
      }
    </div>
  );
}

export default App;
