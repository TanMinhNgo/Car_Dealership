tailwind.config = {
  content: ["./src/**/*.{html,js}"],
  corePlugins: {
    container: false,
  },
  theme: {
    extend: {
      fontFamily: {
        jakarta: ["Plus Jakarta Sans", "serif"],
      },
      colors: {
        primary: "#000",
        secondary: "#bebeb9",
        gray: "#8a8a8a",
      },
      maxWidth: {
        "5xl": "1480px",
      },
      fontSize: {
        medium: "32px",
        large: "48px",
        extra: "56px",
      },
      screens: {
        // sm: "768px",
        // md: "1024px",
        // ld: "1280px",
      },
    },
  },
  plugins: [],
};
