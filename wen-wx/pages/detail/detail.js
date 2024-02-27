Page({
  data: {
    messages: [], // 存储消息列表
    inputValue: '', // 输入框内容
    toView: '', // scroll-view 滚动到的位置
  },

  onLoad() {
    // 模拟接收到的消息
    const messages = [
      { 
        type: 'received', 
        content: '你好，这是一条收到的消息', 
        avatar: 'http://tmp/ZagaEuCO00J320a5a1599b9b610f18ced3d39229c48b.jpeg', 
        time: '12:00' 
      },
      { 
        type: 'sent', 
        content: '你好，这是一条发送的消息', 
        avatar: 'http://tmp/ZagaEuCO00J320a5a1599b9b610f18ced3d39229c48b.jpeg', 
        time: '12:01' 
      },
    ];
    this.setData({ messages });
  },

  inputTyping(e) {
    // 监听输入框内容变化
    this.setData({ inputValue: e.detail.value });
  },

  sendMessage() {
    const { inputValue, messages } = this.data;
    if (!inputValue.trim()) return; // 输入为空时不发送消息

    // 模拟发送消息
    const newMessage = {
      type: 'sent',
      content: inputValue,
      avatar: '发送消息的头像地址',
      time: this.getCurrentTime(),
    };

    // 更新消息列表
    this.setData({
      messages: [...messages, newMessage],
      inputValue: '', // 清空输入框
      toView: `msg-${messages.length}`, // 滚动到最新消息
    });
  },

  getCurrentTime() {
    // 获取当前时间
    const now = new Date();
    const hour = now.getHours().toString().padStart(2, '0');
    const minute = now.getMinutes().toString().padStart(2, '0');
    return `${hour}:${minute}`;
  },
});
